package com.manager.service;

import com.manager.converter.CurrencyDtoToHistoryCurrency;
import com.manager.converter.CurrencyDtoToHistoryCurrencyDto;
import com.manager.converter.HistoryCurrencyToHistoryCurrencyDto;
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

@Service
public class HistoryCurrencyService {
    @Autowired
    private HistoryCurrencyRepository historyCurrencyRepository;
    @Autowired
    private GetCurrencyFromBank getCurrencyFromBank;
    @Autowired
    private HistoryCurrencyToHistoryCurrencyDto historyCurrencyToHistoryCurrencyDto;
    @Autowired
    private CurrencyDtoToHistoryCurrencyDto currencyDtoToHistoryCurrencyDto;
    @Autowired
    private CurrencyDtoToHistoryCurrency currencyDtoToHistoryCurrency;
    @Autowired
    private MnemonicService mnemonicService;

    public HistoryCurrencyDto getCurrency(String mnemonic) throws IOException {
        Integer code = getCode(mnemonic);
        boolean isExist = mnemonicService.isExistMnemonic(mnemonic);
        if (!isExist) {
            throw new NotFoundException("Mnemonic " + mnemonic + " not found.");
        }
        HistoryCurrency historyCurrency = historyCurrencyRepository.findByCodeAndDateCreate(LocalDate.now(), code);
        if (historyCurrency == null) {
            List<CurrencyDto> currencyDtoList = getCurrencyFromBank.getCurrency();
            CurrencyDto currencyDto = currencyDtoList.stream()
                    .filter(f -> f.getCurrencyCodeA().equals(getCode(mnemonic)))
                    .findFirst().orElse(null);
            historyCurrencyRepository.save(currencyDtoToHistoryCurrency.convert(currencyDto));
            return currencyDtoToHistoryCurrencyDto.convert(currencyDto);
        } else {
            historyCurrencyToHistoryCurrencyDto.convert(historyCurrency);
        }
        return historyCurrencyToHistoryCurrencyDto.convert(historyCurrency);
    }

    public Integer getCode(String mnemonic) {
        Integer code = null;
        switch (mnemonic) {
            case "EUR":
                code = 978;
                break;
            case "USD":
                code = 840;
                break;
            case "UAH":
                code = 980;
                break;
        }
        return code;
    }
}
