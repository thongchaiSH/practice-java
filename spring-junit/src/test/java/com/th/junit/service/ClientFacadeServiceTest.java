package com.th.junit.service;

import com.th.junit.domain.SendOTPRequestIntfBO;
import com.th.junit.intf.SendOTPClient;
import com.th.junit.intf.domain.SendOTPRequestBO;
import com.th.junit.intf.domain.SendOTPResponseBO;
import com.th.junit.intf.domain.SendOTPResponseIntfBO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.util.ReflectionTestUtils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

class ClientFacadeServiceTest {

    @Mock
    private SendOTPClient sendOTPClient;

    @InjectMocks
    private ClientFacadeService service;

    private final int expireOTP = 1;//default 1 min

    private final String defaultTemplateSendOTP = "AML";

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        ReflectionTestUtils.setField(service, "expireOTP", expireOTP);
        ReflectionTestUtils.setField(service, "defaultTemplateSendOTP", defaultTemplateSendOTP);
    }

    @Test
    public void should_success_when_sendOTPWithTemplate() {
        //given
        String otpKey = "1234";
        SendOTPResponseIntfBO response = SendOTPResponseIntfBO.builder()
                .otpKey(otpKey)
                .refCode("XUT3")
                .build();
        given(sendOTPClient.execute(any(SendOTPRequestIntfBO.class))).willReturn(response);
        SendOTPRequestBO request = SendOTPRequestBO.builder()
                .phoneNo("0812345678")
                .templateCd("ECOM")
                .build();
        //when
        SendOTPResponseBO result = service.sendOTP(request);
        //then
        then(sendOTPClient).should().execute(
                argThat((SendOTPRequestIntfBO item) ->
                        (
                                item.getTemplateCd().equals("ECOM") &&
                                item.getOtpExpireMin() == expireOTP &&
                                item.getPhoneNo().equals("0812345678")
                        )
                )
        );
        assertThat(result.getOtpKey()).isEqualTo(otpKey);
        assertThat(result.getRefCode()).isEqualTo(response.getRefCode());
        assertThat(result.getExpireOTP()).isEqualTo(60);
    }
}