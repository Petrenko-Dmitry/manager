package com.manager.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UbkiAnswerDto {
    @JsonProperty(value = "bankruptcy_court_name")
    private String bankruptcy_court_name;
    @JsonProperty(value = "errtype")
    private String errType;
    @JsonProperty(value = "termination_doc_date")
    private String terminationDocDate;
    @JsonProperty(value = "source")
    private String source;
    @JsonProperty(value = "termination_doc_number")
    private String terminationDocNumber;
    @JsonProperty(value = "bankruptcy_date_judge")
    private String bankruptcyDateJudge;
    @JsonProperty(value = "termination_canc_number")
    private String terminationCancNumber;
    @JsonProperty(value = "main_activity_code")
    private String mainActivityCode;
    @JsonProperty(value = "activitykinds")
    private List<ActivityKindsDto> activityKinds;
    @JsonProperty(value = "bankruptcy_doc_date")
    private String bankruptcyDocDate;
    @JsonProperty(value = "termination_date_judge")
    private String terminationDateJudge;
    @JsonProperty(value = "found")
    private String found;
    @JsonProperty(value = "termination_record_number")
    private String terminationRecordNumber;
    @JsonProperty(value = "termination_object_name")
    private String terminationObjectName;
    @JsonProperty(value = "fop_tel")
    private List<String> fopTel;
    private Map<String, String> phone;
}
