package com.manager.controller;

import com.manager.dto.CurrencyDto;
import com.manager.dto.HistoryCurrencyDto;
import com.manager.dto.ExistCurrencyDto;
import com.manager.service.GetCurrencyFromBank;
import com.manager.service.HistoryCurrencyService;
import com.manager.service.MnemonicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;


@RestController
public class CurrencyController {

    @Autowired
    private HistoryCurrencyService historyCurrencyService;
    @Autowired
    private MnemonicService mnemonicService;
    @Autowired
    private GetCurrencyFromBank getCurrencyFromBank;

    @GetMapping("/getCurrency")
    public HistoryCurrencyDto getCurrency(@RequestParam String mnemonic) throws IOException {
        return historyCurrencyService.getCurrency(mnemonic);
    }

    @GetMapping("/getCodeCurrency")
    public Integer getCodeCurrency(@RequestParam String mnemonic) {
        return historyCurrencyService.getCode(mnemonic);
    }

    @PostMapping("/saveCurrency")
    public void getCodeCurrency(@RequestBody ExistCurrencyDto newCurrencyDto) {
        mnemonicService.saveMnemonic(newCurrencyDto);
    }

    @GetMapping("/getAll")
    public List<ExistCurrencyDto> getAll() {
        return mnemonicService.getAll();
    }


    @GetMapping("/getCurrencyFromBank")
    public List<CurrencyDto> getCurrency() throws IOException {
        return getCurrencyFromBank.getCurrency();
    }
}
