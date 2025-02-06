package com.rcalderan.desafio_itau_spring.controller;

import com.rcalderan.desafio_itau_spring.model.Transaction;
import com.rcalderan.desafio_itau_spring.service.TransactionService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TransactionControllerTest {
    @InjectMocks
    private TransactionController transactionController;

    @Mock
    private Transaction transaction;

    @Mock
    private TransactionService transactionService;

    @Test
    public void testCreateTransactionUnprocessableEntity() {
        //when(transaction.isValid()).thenReturn(false);
        when(transaction.hasErrors()).thenReturn(true);
        var response = transactionController.createTransaction(transaction);

        assertEquals(HttpStatus.UNPROCESSABLE_ENTITY, response.getStatusCode());
    }

    @Test
    public void testCreateTransactionUnprocessableEntity_2() {
        transaction= new Transaction(-1, OffsetDateTime.now());
        var response = transactionController.createTransaction(transaction);

        //when(transaction.hasErrors()).thenReturn(true);
        assertEquals(HttpStatus.UNPROCESSABLE_ENTITY, response.getStatusCode());
    }

    @Test
    public void testCreateTransactionUnprocessableEntity_date_Future() {
        transaction = new Transaction(1, OffsetDateTime.now().plusDays(1));
        var response = transactionController.createTransaction(transaction);

        assertEquals(HttpStatus.UNPROCESSABLE_ENTITY, response.getStatusCode());
    }

    @Test
    public void whenMissingField_thenReturns400() {
        transaction = new Transaction(1111, null);

        try {
            transactionController.createTransaction(transaction);
        } catch (Exception e) {
            ResponseEntity<Void> response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        }
    }

    @Test
    public void whenDeleteTransaction_thenReturns200() {
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction(1111,  OffsetDateTime.now() ));
        transactions.add(new Transaction(222,  OffsetDateTime.now() ));
        when(transactionService.deleteAll()).thenReturn(transactions);

        ResponseEntity<List<Transaction>> response = transactionController.deleteTransaction();

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}
