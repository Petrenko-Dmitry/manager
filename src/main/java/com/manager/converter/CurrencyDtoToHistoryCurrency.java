package com.manager.converter;

import com.manager.dto.CurrencyDto;
import com.manager.entity.HistoryCurrency;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class CurrencyDtoToHistoryCurrency implements Converter<CurrencyDto, HistoryCurrency> {
    @Override
    public HistoryCurrency convert(CurrencyDto currencyDto) {
        HistoryCurrency historyCurrency = new HistoryCurrency();
        historyCurrency.setBuy(currencyDto.getRateBuy());
        historyCurrency.setSale(currencyDto.getRateSell());
        historyCurrency.setCode(currencyDto.getCurrencyCodeA());
        return historyCurrency;
    }
}
