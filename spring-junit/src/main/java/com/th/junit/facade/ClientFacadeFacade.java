package com.th.junit.facade;

import com.th.junit.intf.domain.SendOTPRequestBO;
import com.th.junit.intf.domain.SendOTPResponseBO;
import com.th.junit.service.ClientFacadeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ClientFacadeFacade {

    @Autowired
    private  ClientFacadeService clientfacadeService;

    public SendOTPResponseBO sendOTP(SendOTPRequestBO request) {
        return clientfacadeService.sendOTP(request);
    }
}
