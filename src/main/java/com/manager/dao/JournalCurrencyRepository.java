package com.manager.dao;

import com.manager.entity.JournalCurrency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface JournalCurrencyRepository extends JpaRepository<JournalCurrency, Long> {

    @Query("select count(id) from JournalCurrency ")
    Long countAll();

    boolean existsByMnemonic(String mnemonic);
}
