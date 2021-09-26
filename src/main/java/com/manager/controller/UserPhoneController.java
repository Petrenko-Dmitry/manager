package com.manager.controller;


import com.manager.dto.UbkiAnswerDto;
import com.manager.service.ParseUbkiAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class UserPhoneController {
    @Autowired
    private ParseUbkiAnswerService parseUbkiAnswerService;


    /* Имитация стороннего сервиса для расшифровки телефонов

     */
    @GetMapping("/encrypt")
    public String encrypt(@RequestParam String uid) throws IOException {
        String phone = null;
        switch (uid) {
            case "qwe":
                phone = "000";
                break;
            case "qwer":
                phone = "111";
                break;
            case "qwert":
                phone = "222";
                break;
        }
        return phone;
    }

    @GetMapping("/decrypt")
    public String decrypt(@RequestParam String phone) {
        String uid = null;
        switch (phone) {
            case "000":
                uid = "qwe";
                break;
            case "111":
                uid = "qwer";
                break;
            case "222":
                uid = "qwert";
                break;
        }
        return uid;
    }

    /*
    Для вызова сервисов считывания файла ubki.txt и расшифровки телефонов.
     */
    @GetMapping("/getUserInfo")
    public UbkiAnswerDto getUserInfo() throws IOException {
        return parseUbkiAnswerService.getUserInfo();
    }
}
