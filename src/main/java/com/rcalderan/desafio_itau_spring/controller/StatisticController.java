package com.rcalderan.desafio_itau_spring.controller;

import com.rcalderan.desafio_itau_spring.dto.StatisticDTO;
import com.rcalderan.desafio_itau_spring.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estatistica")
public class StatisticController {

    @Autowired
    private TransactionService service;

    @GetMapping
    public ResponseEntity<StatisticDTO> getLastMinStatistic(){
        int TIME = 60;
        return new ResponseEntity<>(service.statistic(TIME), HttpStatus.OK);
    }
}
