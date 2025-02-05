package com.rcalderan.desafio_itau_spring.service;

import com.rcalderan.desafio_itau_spring.model.Transaction;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    /**
     * Save a valid transaction
     * @param transaction
     * @return Transacion or null if fail
     */
    public Transaction saveTransaction(Transaction transaction){
        return null;
    }

    /**
     * Delete all transaction
     *
     * @return List of all Deleted transactions or null
     */
    public List<Transaction> deleteTransaction(){
        return null;
    }
}
