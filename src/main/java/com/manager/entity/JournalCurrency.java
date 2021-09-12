package com.manager.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class JournalCurrency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
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
