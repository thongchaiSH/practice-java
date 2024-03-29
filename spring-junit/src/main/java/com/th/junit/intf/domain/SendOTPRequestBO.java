package com.th.junit.intf.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SendOTPRequestBO {
    private String indexKey;
    private String phoneNo;
    private String otpCode;
    private String refCode;
    private String ttl;
    private String msg;
    private String lang;
    private String templateCd;
    private int otpExpireMin;
    private int incorrectAttempts;
    private int maxIncorrectAttempts;
}


