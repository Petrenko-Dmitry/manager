package com.manager.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExistCurrencyDto {
    private String mnemonic;
    private Integer code;
    private String description;
}
