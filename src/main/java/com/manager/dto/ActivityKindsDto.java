package com.manager.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ActivityKindsDto {
    @JsonProperty("activity_code")
    private String activityCode;
    @JsonProperty("activity_name")
    private String activityName;
}
