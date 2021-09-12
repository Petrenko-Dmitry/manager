package com.manager.service;

import com.manager.converter.JournalCurrencyToExistCurrencyDto;
import com.manager.dao.JournalCurrencyRepository;
import com.manager.dto.ExistCurrencyDto;
import com.manager.entity.JournalCurrency;
import com.manager.exception.EntityExistException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@Slf4j
public class MnemonicService {
    @Autowired
    private JournalCurrencyRepository journalCurrencyRepository;
    @Autowired
    private JournalCurrencyToExistCurrencyDto journalCurrencyToExistCurrencyDto;

    @Cacheable(cacheNames = "currency", key = "#mnemonic")
    public boolean isExistMnemonic(String mnemonic) {
        return journalCurrencyRepository.existsByMnemonic(mnemonic);
    }

    /*
    Два варианта решения, ждем exception и выводим сообщение, или прежде чем сохранять проверяем
    */
    @CacheEvict(cacheNames = "currencyAll")
    public void saveMnemonic(ExistCurrencyDto newCurrencyDto) {
        JournalCurrency newCurrency = new JournalCurrency(newCurrencyDto.getMnemonic(), newCurrencyDto.getCode(), newCurrencyDto.getDescription());
        try {
            if (isExistMnemonic(newCurrencyDto.getMnemonic())) {
                throw new EntityExistException("(mnemonic)=" + newCurrencyDto.getMnemonic() + " уже существует.");
            }
            journalCurrencyRepository.save(newCurrency);
        } catch (DataIntegrityViolationException e) {
            log.error(e.getMessage());
            throw new EntityExistException("(mnemonic)=" + newCurrencyDto.getMnemonic() + " уже существует.", e);
        }
    }

    @Cacheable(cacheNames = "currencyAll")
    public List<ExistCurrencyDto> getAll() {
        return journalCurrencyRepository.findAll()
                .stream()
                .map(one -> journalCurrencyToExistCurrencyDto.convert(one))
                .collect(Collectors.toList());

    }
}
