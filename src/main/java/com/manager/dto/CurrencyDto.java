package com.manager.dto;

public class CurrencyDto {
    private Integer currencyCodeA;
    private Integer currencyCodeB;
    private Integer date;
    private Integer rateBuy;
    private Integer rateSell;

    public int getCurrencyCodeA(int currencyCodeA) {
        return currencyCodeA;
    }
    public int getCurrencyCodeB(int currencyCodeB) {
        return currencyCodeB;
    }
}

