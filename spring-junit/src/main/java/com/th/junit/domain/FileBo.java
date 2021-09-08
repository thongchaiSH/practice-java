package com.th.junit.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.th.junit.utility.BASE64DecodedMultipartFile;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FileBo {

    @NotEmpty
    private String fileContent;

    @NotEmpty
    @Pattern(regexp="^(ID_CARD|SELFIE)$")
    private String type;

    @JsonIgnore
    public MultipartFile getMultipartFile(){
        MultipartFile multipart= BASE64DecodedMultipartFile.base64ToMultipart(fileContent);
        return multipart;
    }

    @Override
    public String toString() {
        return "FileBo{" +
                "fileContent.length='" + fileContent.length() + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
