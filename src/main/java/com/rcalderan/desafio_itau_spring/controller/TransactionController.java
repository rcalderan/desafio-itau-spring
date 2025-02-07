package com.rcalderan.desafio_itau_spring.controller;

import com.rcalderan.desafio_itau_spring.model.Transaction;
import com.rcalderan.desafio_itau_spring.repository.TransactionRepository;
import com.rcalderan.desafio_itau_spring.service.TransactionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transacao")
public class TransactionController {
    private static final Logger logger = LogManager.getLogger(TransactionController.class);

    @Autowired
    private TransactionService transactionService;
    /**
     * Regist a transaction
     * @param transaction
     * @return
     * {
     *     "valor": 123.45,
     *     "dataHora": "2020-08-07T12:34:56.789-03:00"
     * }
     */

    @Operation(summary = "Create a new transaction")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Transaction accepted"),
            @ApiResponse(responseCode = "422", description = "Not accepted"),
            @ApiResponse(responseCode = "500", description = "Internal error")
    })
    @PostMapping
    public ResponseEntity<Void> createTransaction(@RequestBody @Valid Transaction transaction){
        try{
            if (transaction.hasErrors()) {
                logger.info("Transaction rejected: {}",transaction);
                return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
            }else{
                logger.info("Transaction accepted: {}",transaction);
                return new ResponseEntity<>(HttpStatus.CREATED);
            }
        } catch (Exception e) {
            logger.error("Create trasaction error: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @Operation(summary = "Delete all transactions")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All transaction clear"),
            @ApiResponse(responseCode = "204", description = "Nothing to clear"),
            @ApiResponse(responseCode = "500", description = "Internal error")
    })
    @DeleteMapping
    public ResponseEntity<List<Transaction>> deleteTransaction(){
        try{
            List<Transaction> deleted = transactionService.deleteAll();
            if(deleted!= null && !deleted.isEmpty()){
                logger.info("All transaction deleted");
                return new ResponseEntity<>(deleted, HttpStatus.OK);
            }
            logger.info("Trying to delete but nothing to clear");
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception e) {
            logger.error("Delete transactions error: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
