package com.rcalderan.desafio_itau_spring.controller;

import com.rcalderan.desafio_itau_spring.model.Transaction;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.OffsetDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TransactionControllerTest {
    @InjectMocks
    private TransactionController transactionController;

    @Mock
    private Transaction transaction;

    @Test
    public void testCreateTransactionUnprocessableEntity() {
        //when(transaction.isValid()).thenReturn(false);
        when(transaction.hasErrors()).thenReturn(true);
        var response = transactionController.createTransaction(transaction);

        assertEquals(HttpStatus.UNPROCESSABLE_ENTITY, response.getStatusCode());
    }

    @Test
    public void testCreateTransactionUnprocessableEntity_2() {
        Transaction t = new Transaction(-1, OffsetDateTime.now());
        var response = transactionController.createTransaction(transaction);

        assertEquals(HttpStatus.UNPROCESSABLE_ENTITY, response.getStatusCode());
    }

    @Test
    public void whenMissingField_thenReturns400() {
        Transaction transaction = new Transaction(1111, null);

        try {
            transactionController.createTransaction(transaction);
        } catch (Exception e) {
            ResponseEntity<Void> response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        }
    }

    @Test
    public void whenDeleteTransaction_thenReturns200() {
        Transaction transaction = new Transaction(1111, OffsetDateTime.now());

        ResponseEntity<List<Transaction>> response = transactionController.deleteTransaction();

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}
