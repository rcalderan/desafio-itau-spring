package com.rcalderan.desafio_itau_spring.controller;

import com.rcalderan.desafio_itau_spring.dto.StatisticDTO;
import com.rcalderan.desafio_itau_spring.service.TransactionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estatistica")
public class StatisticController {

    private static final Logger logger = LogManager.getLogger(StatisticController.class);

    @Autowired
    private TransactionService service;

    @Operation(summary = "Get transaction statistics in last minute")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Last minute statistics"),
            @ApiResponse(responseCode = "500", description = "Internal error")
    })
    @GetMapping
    public ResponseEntity<StatisticDTO> getLastMinStatistic(){
        try{
            int TIME = 60;
            return new ResponseEntity<>(service.statistic(TIME), HttpStatus.OK);
        } catch (Exception e) {

            logger.error("Statistic error: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Operation(summary = "Get transaction statistics last N seconds")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Last N seconds statistics"),
            @ApiResponse(responseCode = "500", description = "Internal error")
    })
    @GetMapping(value = "/{seconds}")
    public ResponseEntity<StatisticDTO> getStatisticInSeconds(@PathVariable int seconds){
        try{
            logger.info("Get last {} seconds statistics:", seconds);
            return new ResponseEntity<>(service.statistic(seconds), HttpStatus.OK);
        } catch (Exception e) {

            logger.error("Statistic per second error: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
