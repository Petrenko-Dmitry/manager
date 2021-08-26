package com.manager.dao;

import com.manager.entity.HistoryCurrency;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface HistoryCurrencyRepository extends JpaRepository<HistoryCurrency, Long> {
    HistoryCurrency findByCodeAndDateCreate(Integer code,LocalDate dateCreate);
}
