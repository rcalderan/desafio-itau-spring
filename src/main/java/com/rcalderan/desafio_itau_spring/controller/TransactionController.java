package com.rcalderan.desafio_itau_spring.controller;

import com.rcalderan.desafio_itau_spring.model.Transaction;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transacao")
public class TransactionController {

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
            // Se a transação não for aceita por qualquer motivo
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }else{
            return new ResponseEntity<>(HttpStatus.CREATED);
        }

        // Validar a transação
//        if (transaction.isValid()) {
//            // Se a transação for válida e registrada
//            return new ResponseEntity<>(HttpStatus.CREATED);
//        } else if (transaction.hasErrors()) {
//            // Se a transação não for aceita por qualquer motivo
//            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
//        } else {
//            // Se a requisição não for compreendida (JSON inválido, por exemplo)
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
    }

    @DeleteMapping
    public ResponseEntity<List<Transaction>> deleteTransaction(){
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

}
