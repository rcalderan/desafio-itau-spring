package com.rcalderan.desafio_itau_spring.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.OffsetDateTime;

import com.rcalderan.desafio_itau_spring.repository.TransactionRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.rcalderan.desafio_itau_spring.model.Transaction;
import com.rcalderan.desafio_itau_spring.service.TransactionService;

@Slf4j
@ExtendWith(MockitoExtension.class)
public class TransactionServiceTest {

    @InjectMocks
    private TransactionService transactionService;

    @Mock
    private TransactionRepository transactionRepository;


    @Test
    public void mustSaveATransaction_test() {
        Transaction transaction = new Transaction(1111.11, OffsetDateTime.now());
        when(transactionRepository.add(transaction)).thenReturn(true);
        assertTrue(transactionService.saveTransaction(transaction));
    }
}

