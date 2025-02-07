package com.rcalderan.desafio_itau_spring.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class StatisticDTO {
    private long count;
    private double sum;
    private double avg;
    private double min;
    private double max;
}
