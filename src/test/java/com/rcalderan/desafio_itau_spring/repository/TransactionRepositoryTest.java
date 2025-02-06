package com.rcalderan.desafio_itau_spring.repository;
import com.rcalderan.desafio_itau_spring.data.Data;
import com.rcalderan.desafio_itau_spring.model.Transaction;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TransactionRepositoryTest {

    @InjectMocks
    private TransactionRepository repository;

    @Mock
    private Data db;

//    @BeforeEach
//    public void setup(){
//        List<Transaction> list = new ArrayList<>();
//        list.add((new Transaction(11, OffsetDateTime.now().minusDays(1))));
//        list.add((new Transaction(112, OffsetDateTime.now().minusDays(2))));
//        when(db.getTransactions()).thenReturn(list);
//    }

    @Test
    public void addSuccess(){
        Transaction t = new Transaction(113, OffsetDateTime.now().minusDays(3));
        assertTrue(repository.add(t));
    }

    @Test
    public void deleteAll(){
        List<Transaction> list = new ArrayList<>();
        list.add((new Transaction(11, OffsetDateTime.now().minusDays(1))));
        when(db.deleteAll()).thenReturn(list);
        assertEquals(repository.deleteAll(), list);
    }
}
