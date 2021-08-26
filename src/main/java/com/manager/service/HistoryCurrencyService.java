package com.manager.service;

import com.manager.dao.HistoryCurrencyRepository;
import com.manager.dao.JournalCurrencyRepository;
import com.manager.dto.CurrencyDto;
import com.manager.dto.HistoryCurrencyDto;
import com.manager.entity.HistoryCurrency;
import com.manager.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HistoryCurrencyService {
    @Autowired
    private JournalCurrencyRepository journalCurrencyRepository;
    @Autowired
    private HistoryCurrencyRepository historyCurrencyRepository;
    @Autowired
    private GetCurrencyFromBank getCurrencyFromBank;


    public List<CurrencyDto> getCurrency(String mnemonic) throws IOException {
        Integer code = getCode(mnemonic);
        boolean isExist = journalCurrencyRepository.existsByMnemonic(mnemonic);
        if (!isExist) {
            throw new NotFoundException("Mnemonic " + mnemonic + " not found.");
        }
        HistoryCurrency codeDateCurrency = historyCurrencyRepository.findByCodeAndDateCreate(code, LocalDate.now());
        if (codeDateCurrency == null) {
            List<CurrencyDto> currencyDtoList = getCurrencyFromBank.getCurrency();
            List<CurrencyDto> currencyDtoListSort = currencyDtoList.stream()
                    .filter(f -> f.getCurrencyCodeA(840) == getCode("UAH") && f.getCurrencyCodeB(980) == getCode("USD"))
                    .filter(f -> f.getCurrencyCodeA(840) == getCode("UAH") && f.getCurrencyCodeB(978) == getCode("EUR"))
                    .collect(Collectors.toList());
            List<HistoryCurrency> historyCurrencyList = currencyDtoList
                    .stream()
                    .map(m->)
        }

        return null;
    }

    public Integer getCode(String mnemonic) {
        Integer code = null;
        switch (mnemonic) {
            case "EUR":
                code = 978;
                break;
            case "USD":
                code = 980;
                break;
            case "UAH":
                code = 840;
                break;
        }
        return code;
    }
}
