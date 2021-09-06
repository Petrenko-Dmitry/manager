package com.manager.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.time.LocalDate;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrencyDto {
    private Integer currencyCodeA;
    private Integer currencyCodeB;
    private Integer date;
    private Double rateBuy;
    private Double rateSell;

    public int getCurrencyCodeA(int currencyCodeA) {
        return currencyCodeA;
    }

    public int getCurrencyCodeB(int currencyCodeB) {
        return currencyCodeB;
    }

    public Double getRateSell() {
        return rateSell;
    }
}

