package com.manager.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ApiKeyController {

    /*
    Даем возможность нескольких ключей
     */
    @Value("#{'${server.key}'.split(',')}")
    private List<String> apiKeys;
    /*
    Имитируем обращение к стороннему сервису
     */
    @PostMapping("/checkApiKey")
    public boolean checkApiKey(@RequestBody String apiKey) {
        return apiKeys.contains(apiKey);
    }
}
