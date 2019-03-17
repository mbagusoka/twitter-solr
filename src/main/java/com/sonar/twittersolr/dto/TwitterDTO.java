package com.sonar.twittersolr.dto;

import com.fasterxml.jackson.annotation.JsonAnySetter;

import java.util.LinkedHashMap;
import java.util.Map;

public class TwitterDTO {

    private Map<String, Object> fields = new LinkedHashMap<>();

    public Map<String, Object> getFields() {
        return fields;
    }

    @JsonAnySetter
    public void setFields(String key, Object value) {
        fields.put(key, value);
    }
}
