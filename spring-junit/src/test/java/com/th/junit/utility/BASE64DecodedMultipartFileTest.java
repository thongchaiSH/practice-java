package com.th.junit.utility;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Test;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class BASE64DecodedMultipartFileTest {
    private String imageBase64() throws Exception{
        ClassLoader classLoader=getClass().getClassLoader();
        FileInputStream file=new FileInputStream(classLoader.getResource("AML/ImageBase64.txt").getFile()) ;
        String stringTooLong = IOUtils.toString(file, "UTF-8");
        return stringTooLong;
    }

    @Test
    public void should_convertImage_success() throws Exception{
        String base64=this.imageBase64();
        MultipartFile multipart=BASE64DecodedMultipartFile.base64ToMultipart(base64);
        log.info(multipart.getName());
    }
}