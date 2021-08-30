package th.co.fwd.ecommerce.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import th.co.fwd.ecommerce.intf.domain.FaceRecognitionBO;

import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class FaceRecognitionRequestBo {

    @JsonProperty("force_face_comparison")
    private Boolean forceFaceComparison;

    @JsonProperty("accepted_consents")
    private List<String> acceptedConsents;

    @JsonProperty("customer_data")
    private FaceRecognitionBO customerData;

    private List<FileBo> files;
}
