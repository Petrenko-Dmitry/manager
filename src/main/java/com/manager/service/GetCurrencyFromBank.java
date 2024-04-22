package com.manager.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.manager.dto.CurrencyDto;
import org.apache.http.client.fluent.Request;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

@Service
public class GetCurrencyFromBank {

    @Value("${api.endpoint}")
    private String bankUrl;

    public List<CurrencyDto> getCurrency() throws IOException {
        var request = Request.Get(bankUrl);
        var getEntity = request.execute().returnResponse().getEntity();

        var reader = new BufferedReader(new InputStreamReader(getEntity.getContent()));
        var builder = new StringBuilder();
        String field;
        while ((field = reader.readLine()) != null) {
            builder.append(field);
            builder.append('\r');
        }

        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(builder.toString(), new TypeReference<>() {});
    }
}
