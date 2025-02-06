package com.rcalderan.desafio_itau_spring.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.OffsetDateTime;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class TransactionTest {

    @Mock
    private Transaction transaction;


    @Test
    public void hasErrors(){
        transaction = new Transaction(11, OffsetDateTime.now().minusDays(1));
        assertFalse(transaction.hasErrors());
    }
    @Test
    public void hasErrors_negativeValue(){
        transaction = new Transaction(-1, OffsetDateTime.now());
        assertTrue(transaction.hasErrors());
    }

    @Test
    public void hasErrors_futureData(){
        transaction = new Transaction(1, OffsetDateTime.now().plusDays(1));
        assertTrue(transaction.hasErrors());
    }
}
