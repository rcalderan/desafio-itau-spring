package com.rcalderan.desafio_itau_spring.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.List;

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
    //statistic

    @Test
    public void statistcLastMin_test() {
        List<Transaction> transacoes = List.of(
                new Transaction(100.0, OffsetDateTime.now(ZoneOffset.UTC).minusSeconds(30)),
                new Transaction(200.0, OffsetDateTime.now(ZoneOffset.UTC).minusSeconds(90)),
                new Transaction(50.0, OffsetDateTime.now(ZoneOffset.UTC).minusSeconds(45)),
                new Transaction(300.0, OffsetDateTime.now(ZoneOffset.UTC).minusSeconds(10))
        );
        when(transactionRepository.getAll()).thenReturn(transacoes);
        assertNotEquals(0, transactionService.statistic(60).getAvg());
    }
}

