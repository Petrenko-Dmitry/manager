package com.manager.converter;

import com.manager.dto.ExistCurrencyDto;
import com.manager.entity.JournalCurrency;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class JournalCurrencyToExistCurrencyDto implements Converter<JournalCurrency, ExistCurrencyDto> {

    @Override
    public ExistCurrencyDto convert(JournalCurrency journalCurrency) {
        ExistCurrencyDto existCurrencyDto = new ExistCurrencyDto();
        existCurrencyDto.setCode(journalCurrency.getCode());
        existCurrencyDto.setMnemonic(journalCurrency.getMnemonic());
        existCurrencyDto.setDescription(journalCurrency.getDescription());
        return existCurrencyDto;
    }
}
