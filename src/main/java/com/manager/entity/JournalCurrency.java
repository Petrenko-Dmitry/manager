package com.manager.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class JournalCurrency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mnemonic;
    private Integer code;
    private String description;

    public JournalCurrency() {
    }

    public JournalCurrency(String mnemonic, Integer code, String description) {
        this.mnemonic = mnemonic;
        this.code = code;
        this.description = description;
    }
}
