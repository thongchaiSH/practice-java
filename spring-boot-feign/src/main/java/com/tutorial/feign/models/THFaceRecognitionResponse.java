package com.tutorial.feign.models;

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
public class THFaceRecognitionResponse {
    private String referenceId;
    private Map<String, String> person;
    private Map<String, String> registraiton;
    private Map<String, String> seller;
    private List<Object> documents;
    private List<Object> consents;
    private List<Object> verifications;
}
