package com.th.junit.service;

import com.th.junit.domain.SendOTPRequestIntfBO;
import com.th.junit.intf.SendOTPClient;
import com.th.junit.intf.domain.SendOTPRequestBO;
import com.th.junit.intf.domain.SendOTPResponseBO;
import com.th.junit.intf.domain.SendOTPResponseIntfBO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ClientFacadeService {

    private final SendOTPClient sendOTPClient;

    @Value("${otpservice.otp.expire.min:5}")
    private int expireOTP;

    @Value("${otpservice.otp.max.incorrect.attempts}")
    private int maxIncorrectAttemptsConf;

    @Value("${otpservice.sendOTP.defaultTemplate}")
    private String defaultTemplateSendOTP;

    public SendOTPResponseBO sendOTP(SendOTPRequestBO request) {
        SendOTPRequestIntfBO requestIntfBO = SendOTPRequestIntfBO.builder()
                .indexKey(request.getIndexKey())
                .phoneNo(request.getPhoneNo())
                .otpCode(request.getOtpCode())
                .refCode(request.getRefCode())
                .lang(request.getLang())
                .ttl(request.getTtl())
                .msg(request.getMsg())
                .templateCd(StringUtils.isNotEmpty(request.getTemplateCd())?request.getTemplateCd():defaultTemplateSendOTP)
                .otpExpireMin(request.getOtpExpireMin() > 0 ? request.getOtpExpireMin() : expireOTP)
                .incorrectAttempts(request.getIncorrectAttempts())
                .maxIncorrectAttempts(request.getMaxIncorrectAttempts() > 0 ? request.getMaxIncorrectAttempts() : maxIncorrectAttemptsConf)
                .build();

        SendOTPResponseIntfBO responseIntfBO = sendOTPClient.execute(requestIntfBO);
        log.info("SendOTPRequestIntfBO:: {}",requestIntfBO);
        SendOTPResponseBO response=SendOTPResponseBO.builder()
                .refCode(responseIntfBO.getRefCode())
                .otpKey(responseIntfBO.getOtpKey())
                .expireOTP(requestIntfBO.getOtpExpireMin() * 60)
                .build();
        log.info("SendOTPResponseBO:: {}",response);

        return response;
    }
}
