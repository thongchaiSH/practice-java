package th.co.fwd.ecommerce.intf;


import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import th.co.fwd.ecommerce.intf.domain.FaceRecognitionBO;

import java.util.List;


@FeignClient(
        value = "UploadClient", url = "${amlservice.baseurl}"
)
public interface UploadClient {

    @PostMapping(value = "/customers/kyc/123/documents",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    FaceRecognitionBO faceRecognition(
            @RequestParam("force_face_comparison")Boolean forceFaceComparison,
            @RequestParam( "accepted_consents") List<String> acceptedConsents,
            @RequestParam("types") List<String> types,
            @RequestPart("files") MultipartFile files
    );

    @PostMapping(value = "/customers/kyc/123/documents", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    FaceRecognitionBO upload(@RequestPart("files") MultipartFile files);

}
