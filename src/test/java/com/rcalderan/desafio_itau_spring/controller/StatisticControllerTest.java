package com.rcalderan.desafio_itau_spring.controller;

import com.rcalderan.desafio_itau_spring.dto.StatisticDTO;
import com.rcalderan.desafio_itau_spring.model.Transaction;
import com.rcalderan.desafio_itau_spring.service.TransactionService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StatisticControllerTest {
    @InjectMocks
    private StatisticController statisticController;

    @Mock
    private TransactionService transactionService;

    @Test
    public void testCreateStatisticEntity_OK() {
        var response = statisticController.getLastMinStatistic();

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void testCreateStatisticResposneK() {
        StatisticDTO expected = new StatisticDTO(150,10,20,30, 40);
        when(transactionService.statistic(60)).thenReturn(expected);
        ResponseEntity<StatisticDTO> response = statisticController.getLastMinStatistic();
        assertNotNull(response.getBody());
        assertEquals(expected, response.getBody());
    }
}
