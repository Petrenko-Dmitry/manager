package com.manager.command;

import com.manager.dao.JournalCurrencyRepository;
import com.manager.entity.JournalCurrency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Order(1)
public class JournalCurrencyLoader implements CommandLineRunner {
    @Autowired
    private JournalCurrencyRepository journalCurrencyRepository;

    @Override
    public void run(String... args) {
        Long count = journalCurrencyRepository.countAll();
        if (count < 1) {
            JournalCurrency journalUSD = new JournalCurrency("USD", 840, " Доллар");
            JournalCurrency journalEUR = new JournalCurrency("EUR", 978, " Евро");
            JournalCurrency journalUAH = new JournalCurrency("UAH", 980, " Гривна");
            journalCurrencyRepository.saveAll(Arrays.asList(journalUSD, journalEUR, journalUAH));
        }
    }
}
