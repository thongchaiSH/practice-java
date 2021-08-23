package com.tutorial.feign.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;


import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class FaceRecognitionRequestBo {
    private Boolean forceFaceComparison;
    private List<MultipartFile> files;
    private List<String> acceptedConsents;
    private List<String>types;
    private FaceRecognitionBO customerData;


}
