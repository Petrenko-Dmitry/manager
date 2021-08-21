package com.manager.service;

import com.manager.dao.HistoryCurrencyRepository;
import com.manager.dao.JournalCurrencyRepository;
import com.manager.dto.HistoryCurrencyDto;
import com.manager.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HistoryCurrencyService {
    @Autowired
    private JournalCurrencyRepository journalCurrencyRepository;
    private HistoryCurrencyRepository historyCurrencyRepository;


    public HistoryCurrencyDto getCurrency(String mnemonic){
        boolean isExist = journalCurrencyRepository.existsByMnemonic(mnemonic);
        if (!isExist){
            throw new NotFoundException("Mnemonic "+ mnemonic+ " not found.");
        }

        return null;
    }
}
