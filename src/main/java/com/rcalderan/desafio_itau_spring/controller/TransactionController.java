package com.rcalderan.desafio_itau_spring.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transacao")
public class TransactionController {

    /**
     * Regist a transaction
     * @param transaction
     * @return
     * {
     *     "valor": 123.45,
     *     "dataHora": "2020-08-07T12:34:56.789-03:00"
     * }
     */
    @PostMapping
    public Object save(@RequestBody Object transaction){
        return transaction;
    }

}
