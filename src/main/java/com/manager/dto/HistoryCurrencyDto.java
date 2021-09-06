package com.manager.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.time.LocalDate;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class HistoryCurrencyDto {
    private LocalDate dateCreate;
    private Integer code;
    private Double buy;
    private Double sale;
}
