package com.manager.converter;

import com.manager.dto.CurrencyDto;
import com.manager.dto.HistoryCurrencyDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

@Component
public class CurrencyDtoToHistoryCurrencyDto implements Converter<CurrencyDto, HistoryCurrencyDto> {
    @Override
    public HistoryCurrencyDto convert(CurrencyDto currencyDto) {
        HistoryCurrencyDto historyCurrencyDto = new HistoryCurrencyDto();
        historyCurrencyDto.setSale(currencyDto.getRateSell());
        historyCurrencyDto.setBuy(currencyDto.getRateBuy());
        LocalDate date =
                Instant.ofEpochSecond(currencyDto.getDate()).atZone(ZoneId.systemDefault()).toLocalDate();
        historyCurrencyDto.setDateCreate(date);
        return historyCurrencyDto;
    }
}
