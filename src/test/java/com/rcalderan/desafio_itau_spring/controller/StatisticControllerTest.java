package com.rcalderan.desafio_itau_spring.controller;

import com.rcalderan.desafio_itau_spring.dto.StatisticDTO;
import com.rcalderan.desafio_itau_spring.model.Transaction;
import com.rcalderan.desafio_itau_spring.service.TransactionService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StatisticControllerTest {
    @InjectMocks
    private StatisticController statisticController;

    @Test
    public void testCreateStatisticEntity_OK() {
        var response = statisticController.getStatistic();

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void testCreateStatisticResposneK() {

        List<Transaction> transacoes = List.of(
                new Transaction(100.0, OffsetDateTime.now(ZoneOffset.UTC).minusSeconds(30)),
                new Transaction(200.0, OffsetDateTime.now(ZoneOffset.UTC).minusSeconds(50)),
                new Transaction(50.0, OffsetDateTime.now(ZoneOffset.UTC).minusSeconds(90)),
                new Transaction(150.0, OffsetDateTime.now(ZoneOffset.UTC).minusSeconds(10))
        );
        Double expectedAvg = 150.0;
        ResponseEntity<StatisticDTO> response = statisticController.getStatistic();
        assertEquals(expectedAvg, response.getBody());
    }
}
