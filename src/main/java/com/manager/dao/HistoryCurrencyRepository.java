package com.manager.dao;

import com.manager.entity.HistoryCurrency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;

public interface HistoryCurrencyRepository extends JpaRepository<HistoryCurrency, Long> {

    @Query("SELECT u FROM HistoryCurrency u WHERE u.dateCreate = :dateCreate and u.code = :code")
    HistoryCurrency findByCodeAndDateCreate(@Param("dateCreate") LocalDate dateCreate, @Param("code") Integer code);
}
