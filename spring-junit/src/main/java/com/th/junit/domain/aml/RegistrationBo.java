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
public class RegistrationBo {
    @NotEmpty
    private String id;

    @NotEmpty
    @Pattern(regexp="^(ID_CARD|PASSPORT)$")
    private String type;

    private String createdAt;
    private String updatedAt;
}
