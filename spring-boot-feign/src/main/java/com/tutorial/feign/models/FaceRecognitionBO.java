package com.tutorial.feign.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class FaceRecognitionBO {
    private String applicationNumber;
    private String referenceId;
    private Map<String, String> person;
    private Map<String, String> registraiton;
    private Map<String, String> seller;
    private List<Object> documents;
    private List<Object> consents;
    private List<Object> verifications;
}
