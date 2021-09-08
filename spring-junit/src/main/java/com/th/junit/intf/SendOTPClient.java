package com.th.junit.intf;

import com.th.junit.domain.SendOTPRequestIntfBO;
import com.th.junit.intf.domain.SendOTPResponseIntfBO;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(
        value = "SendOTPClient", url = "123"
)
public interface SendOTPClient {
    SendOTPResponseIntfBO execute(SendOTPRequestIntfBO request);
}
