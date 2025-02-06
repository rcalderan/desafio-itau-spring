package com.rcalderan.desafio_itau_spring.data;

import com.rcalderan.desafio_itau_spring.model.Transaction;
import com.rcalderan.desafio_itau_spring.service.TransactionService;
import lombok.Getter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Simulate a database
 */
@Getter
@Component
public class Data {

    private static final Logger logger = LogManager.getLogger(Data.class);

    private final List<Transaction> transactions;

    public Data(){
        transactions = new ArrayList<Transaction>();
    }

    /**
     * Delete all transactions
     * @return deleted transactions or null if fails
     */
    public List<Transaction> deleteAll(){
        try{
            List<Transaction> deleted = new ArrayList<>(transactions);
            deleted.addAll(transactions);
            transactions.clear();
            return deleted;
        } catch (Exception e) {
            logger.error(e.getMessage());
            return null;
        }
    }

}
