package com.rcalderan.desafio_itau_spring.model;

import com.rcalderan.desafio_itau_spring.service.TransactionService;
import lombok.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.OffsetDateTime;
@Getter
public class Transaction {
    private static final Logger logger = LogManager.getLogger(TransactionService.class);
    private double value;
    private OffsetDateTime date;

    public Transaction(double value, OffsetDateTime date) {
        this.value = value;
        this.date = date;

        logger.info("Log instance: {}", this);
    }

    // toString()
    @Override
    public String toString() {
        return "Transaction{" +
                "value=" + value +
                ", date=" + date +
                '}';
    }
}
