package com.manager.dao;

import com.manager.entity.HistoryCurrency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryCurrencyRepository extends JpaRepository<HistoryCurrency, Long> {
}
