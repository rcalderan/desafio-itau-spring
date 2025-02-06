package com.rcalderan.desafio_itau_spring.repository;

import com.rcalderan.desafio_itau_spring.data.Data;
import com.rcalderan.desafio_itau_spring.model.Transaction;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TransactionRepository {

    private static final Logger logger = LogManager.getLogger(TransactionRepository.class);

    @Autowired
    private Data data;

    public List<Transaction> getAll(){
        return data.getTransactions();
    }

    /**
     * Insert new transaction
     * @param transaction
     * @return true if success
     */
    public boolean add(Transaction transaction){
        try{
            logger.info("TransactionRepository.add ");
            //logger.info("Saving transaction: ",transaction);
            return data.getTransactions().add(transaction);
        }catch(Exception e){
            logger.info("TransactionRepository.add error");
            logger.debug(e.getMessage());
            return false;
        }

    }

    public List<Transaction> deleteAll(){
        return data.deleteAll();
    }
}
