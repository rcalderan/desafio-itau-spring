package com.rcalderan.desafio_itau_spring.service;

import com.rcalderan.desafio_itau_spring.dto.StatisticDTO;
import com.rcalderan.desafio_itau_spring.model.Transaction;
import com.rcalderan.desafio_itau_spring.repository.TransactionRepository;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Service
public class TransactionService {

    private static final Logger logger = LogManager.getLogger(TransactionService.class);

    @Autowired
    public TransactionRepository repository;

    /**
     * Save a valid transaction
     * @param transaction
     * @return true if success
     */
    public boolean saveTransaction(Transaction transaction){
        logger.info("TransactionService.saveTransaction");
        return repository.add(transaction);
    }

    /**
     * Delete all transaction
     *
     * @return List of all Deleted transactions or null
     */
    public List<Transaction> deleteAll(){
        return repository.deleteAll();
    }

    public StatisticDTO statistic(int seconds){
        return  new StatisticDTO(0,0,0,0,0);
    }
}
