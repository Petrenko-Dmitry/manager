package com.manager.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.manager.dto.UbkiAnswerDto;
import com.manager.dto.ResultDto;
import org.apache.http.HttpResponse;
import org.apache.http.client.fluent.Request;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import static java.util.Objects.nonNull;


@Service
public class ParseUbkiAnswerService {
    private final ObjectMapper objectMapper = new ObjectMapper();

    private String readFileUbki() throws IOException {
        var inputStream = getClass().getClassLoader().getResourceAsStream("ubki.txt");
        var bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
        var currentLine = new StringBuilder();
        String line;
        while (nonNull((line = bufferedReader.readLine()))) {
            if (!line.isEmpty()) {
                currentLine.append(line);
            }
        }
        return currentLine.toString();
    }

    public UbkiAnswerDto getUserInfo() throws IOException {
        ResultDto resultDto = objectMapper.readValue(readFileUbki(), ResultDto.class);
        UbkiAnswerDto ubkiAnswerDto = resultDto.getResult();
        Map<String, String> phone = new HashMap<>();
        for (String one : ubkiAnswerDto.getFopTel()) {
            phone.put(one, decryptPhone(one));
        }
        ubkiAnswerDto.setPhone(phone);
        return resultDto.getResult();
    }

    private String decryptPhone(String uid) throws IOException {
        HttpResponse response = Request.Get("http://localhost:8081/encrypt?uid=" + uid)
                .addHeader("api-key", "fg78TqaW")
                .execute()
                .returnResponse();

        return EntityUtils.toString(response.getEntity(), "UTF-8");
    }
}
