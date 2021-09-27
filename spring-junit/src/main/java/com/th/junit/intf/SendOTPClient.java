package com.th.junit.intf;

import com.th.junit.domain.SendOTPRequestIntfBO;
import com.th.junit.intf.domain.SendOTPResponseIntfBO;
import feign.Headers;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(
        value = "sendOTPClient", url = "https://api.sit.service.fwd.co.th/devProxy/otpService"
)
public interface SendOTPClient {

    @PostMapping("/sendOTP")
    @Headers("Content-Type: application/json; charset=utf-8")
    SendOTPResponseIntfBO execute(SendOTPRequestIntfBO request);
}
