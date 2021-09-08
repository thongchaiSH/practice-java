package com.th.junit.domain.aml;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Pattern;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PersonBo {

    @Pattern(regexp="^(THAI|FOREIGNER)$")
    private String nationalityType;

    private String title;

    @NotEmpty
    private String firstName;
    private String middleName;

    @NotEmpty
    private String lastName;

    @NotEmpty
    private String dateOfBirth;
    private String phoneNumber;
    private String email;

    @NotEmpty
    @Pattern(regexp="^(FACE_TO_FACE|NON_FACE_TO_FACE)$")
    private String sellingType;

    @NotEmpty
    private String role;
}
