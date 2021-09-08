package com.th.junit.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.th.junit.domain.aml.*;
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
public class FaceRecognitionBO {

    @NotEmpty
    private String applicationNumber;

    @Valid
    @NotNull
    private PersonBo person;

    @Valid
    @NotNull
    private RegistrationBo registration;

    @Valid
    @NotNull
    private SellerBo seller;
    //response
    private String referenceId;
    private List<DocumentBo> documents;
    private List<ConsentsBo> consents;
    private List<VerificationBo> verifications;
}
