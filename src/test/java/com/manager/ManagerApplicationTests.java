package com.manager;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.manager.dto.ResultDto;
import org.apache.http.client.fluent.Request;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;


class ManagerApplicationTests {
    @JsonProperty(value = "pib_fop")
    private String pibFop;

    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void contextLoads() throws JsonProcessingException {

        String answer = "{\n" +
                "    \"result\": {\n" +
                "        \"bankruptcy_court_name\": \"\",\n" +
                "        \"errtype\": 0,\n" +
                "        \"termination_doc_date\": \"\",\n" +
                "        \"termination_record_date\": \"\",\n" +
                "        \"source\": \"request\",\n" +
                "        \"termination_doc_number\": \"\",\n" +
                "        \"bankruptcy_date_judge\": \"\",\n" +
                "        \"termination_canc_number\": \"\",\n" +
                "        \"main_activity_code\": \"62.01\",\n" +
                "        \"activitykinds\": [\n" +
                "            {\n" +
                "                \"activity_code\": \"62.09\",\n" +
                "                \"activity_name\": \"Інша діяльність у сфері інформаційних технологій і комп'ютерних систем\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"activity_code\": \"62.03\",\n" +
                "                \"activity_name\": \"Діяльність із керування комп'ютерним устаткованням\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"activity_code\": \"62.02\",\n" +
                "                \"activity_name\": \"Консультування з питань інформатизації\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"activity_code\": \"62.01\",\n" +
                "                \"activity_name\": \"Комп'ютерне програмування\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"bankruptcy_doc_date\": \"\",\n" +
                "        \"termination_date_judge\": \"\",\n" +
                "        \"found\": \"1\",\n" +
                "        \"termination_record_number\": \"\",\n" +
                "        \"termination_object_name\": \"Департамент адміністративних послуг та дозвільних процедур Дніпровської міської ради\",\n" +
                "        \"bankruptcy_rec_date\": \"\",\n" +
                "        \"fop_fax\": [\n" +
                "            \"\"\n" +
                "        ],\n" +
                "        \"fop_email\": [\n" +
                "            \"\"\n" +
                "        ],\n" +
                "        \"is_fop\": \"Y\",\n" +
                "        \"fop_state\": \"1\",\n" +
                "        \"main_activity_recdate\": \"10000000450376\",\n" +
                "        \"open_enforcements\": [\n" +
                "        ],\n" +
                "        \"fop_tel\": [\n" +
                "          \"qwe\",\n" +
                "          \"qwer\",\n" +
                "            \"qwert\"\n" +
                "        ],\n" +
                "        \"risk_class\": \"2\",\n" +
                "        \"registrations\": [\n" +
                "            {\n" +
                "                \"registry_name\": \"ГОЛОВНЕ УПРАВЛІННЯ РЕГІОНАЛЬНОЇ СТАТИСТИКИ\",\n" +
                "                \"registry_code\": \"21680000\",\n" +
                "                \"registry_type\": \"4000.0\",\n" +
                "                \"registry_description\": \"\",\n" +
                "                \"registry_start_date\": \"2015-08-12\",\n" +
                "                \"registry_start_num\": \"\",\n" +
                "                \"registry_end_date\": \"\",\n" +
                "                \"registry_end_num\": \"\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"registry_name\": \"ГОЛОВНЕ УПРАВЛІННЯ ДПС У ДНІПРОПЕТРОВСЬКІЙ ОБЛАСТІ, ЛІВОБЕРЕЖНЕ УПРАВЛІННЯ, АМУР-НИЖНЬОДНІПРОВСЬКА ДПІ (АМУР-НИЖНЬОДНІПРОВСЬКИЙ Р-Н  М.ДНІПРА)\",\n" +
                "                \"registry_code\": \"43145015\",\n" +
                "                \"registry_type\": \"4002.0\",\n" +
                "                \"registry_description\": \"Реєстр платників податків\",\n" +
                "                \"registry_start_date\": \"2015-08-11\",\n" +
                "                \"registry_start_num\": \"046115116304\",\n" +
                "                \"registry_end_date\": \"\",\n" +
                "                \"registry_end_num\": \"\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"registry_name\": \"ГОЛОВНЕ УПРАВЛІННЯ ДПС У ДНІПРОПЕТРОВСЬКІЙ ОБЛАСТІ, ЛІВОБЕРЕЖНЕ УПРАВЛІННЯ, АМУР-НИЖНЬОДНІПРОВСЬКА ДПІ (АМУР-НИЖНЬОДНІПРОВСЬКИЙ Р-Н  М.ДНІПРА)\",\n" +
                "                \"registry_code\": \"43145015\",\n" +
                "                \"registry_type\": \"4001.0\",\n" +
                "                \"registry_description\": \"Реєстр платників єдиного внеску\",\n" +
                "                \"registry_start_date\": \"2015-08-11\",\n" +
                "                \"registry_start_num\": \"10000000450376\",\n" +
                "                \"registry_end_date\": \"\",\n" +
                "                \"registry_end_num\": \"\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"termination_state\": \"\",\n" +
                "        \"bankruptcy_doc_num\": \"\",\n" +
                "        \"termination_cause\": \"\",\n" +
                "        \"reg_record_date\": \"2015-08-11\",\n" +
                "        \"pib_fop\": \"БРОДІ ДЖЕЙСОН АНДРІЙОВИЧ\",\n" +
                "        \"prev_registration_end_term\": \"\",\n" +
                "        \"termination_court_name\": \"\",\n" +
                "        \"main_activity_name\": \"Комп'ютерне програмування\",\n" +
                "        \"update_date\": \"2021-09-10\",\n" +
                "        \"reg_date\": \"2015-08-11\",\n" +
                "        \"fop_web_page\": [\n" +
                "            \"\"\n" +
                "        ],\n" +
                "        \"termination_date\": \"\",\n" +
                "        \"reg_record_number\": \"22240000000101412\",\n" +
                "        \"bankruptcy_rec_state\": \"\"\n" +
                "    }\n" +
                "}\n";
        Request request = Request.Get("http://localhost:8080/test?uid=qwe");


        ResultDto resultDto = objectMapper.readValue(answer, ResultDto.class);
        System.out.println(resultDto);

    }

    @Test
    public void test2() throws IOException {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("ubki.txt");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
        String currentLine = "";
        String line;
        while ((line = bufferedReader.readLine()) != null)
            System.out.println(line);
    }

    @Test
    public void test3() {
        int i = 1, j = 0;
        switch (i) {
            case 2:
                j += 6;
            case 4:
                j += 1;
            default:
                j += 2;
            case 0:
                j += 4;
        }
        System.out.println("j = " + j);
    }
}

