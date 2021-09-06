package com.manager.converter;

import com.manager.dto.HistoryCurrencyDto;
import com.manager.entity.HistoryCurrency;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class HistoryCurrencyToHistoryCurrencyDto implements Converter<HistoryCurrency, HistoryCurrencyDto> {
    @Override
    public HistoryCurrencyDto convert(HistoryCurrency historyCurrency) {
        HistoryCurrencyDto historyCurrencyDto = new HistoryCurrencyDto();
        historyCurrencyDto.setBuy(historyCurrency.getBuy());
        historyCurrencyDto.setSale(historyCurrency.getSale());
        historyCurrencyDto.setCode(historyCurrency.getCode());
        historyCurrencyDto.setDateCreate(historyCurrency.getDateCreate());
        return historyCurrencyDto;
    }
}
