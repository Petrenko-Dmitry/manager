package com.manager.controller;

import com.manager.command.JournalCurrencyLoader;
import com.manager.dto.HistoryCurrencyDto;
import com.manager.service.HistoryCurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CurrencyController {
    @Autowired
    private HistoryCurrencyService historyCurrencyService;

    @GetMapping("/getCurrency")
    public HistoryCurrencyDto getCurrency(@RequestParam String mnemonic) {
        return historyCurrencyService.getCurrency(mnemonic);

    }
}
