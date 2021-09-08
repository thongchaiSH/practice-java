package com.th.junit.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class FaceRecognitionRequestBo {

    @NotNull
    @JsonProperty("force_face_comparison")
    private Boolean forceFaceComparison;

    @JsonProperty("accepted_consents")
    private List<String> acceptedConsents;

    @Valid
    @NotEmpty
    private List<FileBo> files;

    @Valid
    @NotNull
    @JsonProperty("customer_data")
    private FaceRecognitionBO customerData;
}
