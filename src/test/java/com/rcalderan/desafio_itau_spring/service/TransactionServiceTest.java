package com.rcalderan.desafio_itau_spring.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.OffsetDateTime;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.rcalderan.desafio_itau_spring.model.Transaction;
import com.rcalderan.desafio_itau_spring.service.TransactionService;

@Slf4j
@ExtendWith(MockitoExtension.class)
public class TransactionServiceTest {

    @InjectMocks
    private TransactionService transactionService;

    @Test
    public void mustSaveATransaction_test() {
        Transaction transaction = new Transaction(1111.11, OffsetDateTime.now());
        System.out.println(transaction);
        assertNotNull(transactionService.saveTransaction(transaction));
    }
}

