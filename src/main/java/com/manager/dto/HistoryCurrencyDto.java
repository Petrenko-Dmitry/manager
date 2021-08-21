package com.manager.dto;

import lombok.Data;

import java.util.Date;
@Data
public class HistoryCurrencyDto {
    private Date dateCreate;
    private Integer code;
    private Integer buy;
    private Integer sale;
}
