package com.manager.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
@Data
@Entity
public class HistoryCurrency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @CreationTimestamp
    @Column(columnDefinition = "DATE")
    private LocalDate dateCreate;
    private Integer code;
    private Double buy;
    private Double sale;

    public HistoryCurrency() {
    }

    public HistoryCurrency(LocalDate dateCreate, Integer code, Double buy, Double sale) {
        this.dateCreate = dateCreate;
        this.code = code;
        this.buy = buy;
        this.sale = sale;
    }

    public Double getSale() {
        return sale;
    }
}
