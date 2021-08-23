package com.tutorial.feign.client;

import com.tutorial.feign.models.FaceRecognitionBO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@FeignClient(
        value = "UploadClient", url = "${th.ws.url}"
)
public interface UploadClient {

    @PostMapping(value = "/faceRecognition", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    FaceRecognitionBO faceRecognition(
            @RequestParam("force_face_comparison")Boolean forceFaceComparison,
            @RequestParam( "accepted_consents") List<String> acceptedConsents,
            @RequestParam("types") List<String> types,
            @RequestParam("customer_data") String customerData,
            @RequestPart("files")List<MultipartFile> files
    );
}
