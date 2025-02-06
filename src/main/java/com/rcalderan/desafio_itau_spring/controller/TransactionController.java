package com.rcalderan.desafio_itau_spring.controller;

import com.rcalderan.desafio_itau_spring.model.Transaction;
import com.rcalderan.desafio_itau_spring.repository.TransactionRepository;
import com.rcalderan.desafio_itau_spring.service.TransactionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transacao")
public class TransactionController {

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
    @PostMapping
    public ResponseEntity<Void> createTransaction(@RequestBody @Valid Transaction transaction){
        if (transaction.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }else{
            return new ResponseEntity<>(HttpStatus.CREATED);
        }

    }

    @DeleteMapping
    public ResponseEntity<List<Transaction>> deleteTransaction(){
        List<Transaction> deleted = transactionService.deleteAll();
        if(deleted!= null && !deleted.isEmpty()){
            return new ResponseEntity<>(deleted, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
