package com.th.junit.intf.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SendOTPResponseBO {
    private String otpKey;
    private String refCode;
    private Integer expireOTP;
}
