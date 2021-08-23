package com.tutorial.feign.service;

import com.tutorial.feign.models.FaceRecognitionRequestBo;
import com.tutorial.feign.models.THFaceRecognitionResponse;
import com.tutorial.feign.util.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.MultipartBodyBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;

@Slf4j
@Service
public class THConnector implements InitializingBean {

    @Value("${th.ws.url}")
    private String wsUrl;

    private WebClient httpClient;

    private static final String END_POINT_FETCH_FACE_RECOGNITION = "/faceRecognition";

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("afterPropertiesSet. Initializing TH API connector for {}", wsUrl);

        httpClient = WebClient.builder().baseUrl(wsUrl).defaultHeaders(this::setDefaultHeaders).build();

        log.info("afterPropertiesSet. Initialized TH API connector. url={}", wsUrl);
    }

    private void setDefaultHeaders(HttpHeaders headers){
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAcceptCharset(Arrays.asList(Charset.forName("UTF-8")));
    }

    public Object faceRecognition(FaceRecognitionRequestBo requestBo) throws Exception{
        MultipartBodyBuilder body=new MultipartBodyBuilder();
        body.part("force_face_comparison",requestBo.getForceFaceComparison());
        body.part("customer_data",JsonUtils.toJson(requestBo.getCustomerData()));
        requestBo.getTypes().forEach(type->{
            body.part("types",type);
        });
        requestBo.getAcceptedConsents().forEach(accept->{
            body.part("accepted_consents",accept);
        });
        requestBo.getFiles().forEach(file->{
            try {
                String header1 = String.format("form-data; name=%s; filename=%s", file.getName(), file.getOriginalFilename());
                body.part("files", new ByteArrayResource(file.getBytes())).header("Content-Disposition", header1);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        String responseStr = null;
        Object response = new THFaceRecognitionResponse();
        log.info("get faceRecognition. Requesting.");
        responseStr = httpClient.post()
                .uri(END_POINT_FETCH_FACE_RECOGNITION)
                .contentType(MediaType.MULTIPART_FORM_DATA)
                .body(BodyInserters.fromMultipartData(body.build()))
                .retrieve()
                .bodyToMono(String.class)
                .block();

        log.info("fetch faceRecognition. Done. responseStr={}", responseStr);

        response = JsonUtils.toJavaBeanIgnoreCase(responseStr, THFaceRecognitionResponse.class);

        log.info("fetch faceRecognition. Done. response={}", response.toString());

        return response;
    }



}
