package th.co.fwd.ecommerce.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;
import th.co.fwd.ecommerce.utility.BASE64DecodedMultipartFile;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FileBo {
    private String fileContent;
    private String type;

    @JsonIgnore
    public MultipartFile getMultipartFile(){
        MultipartFile multipart=BASE64DecodedMultipartFile.base64ToMultipart(fileContent);
        return multipart;
    }
}
