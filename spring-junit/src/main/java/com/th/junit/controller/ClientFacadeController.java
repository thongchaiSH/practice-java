package com.th.junit.controller;

import com.th.junit.facade.ClientFacadeFacade;
import com.th.junit.intf.domain.SendOTPRequestBO;
import com.th.junit.intf.domain.SendOTPResponseBO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/clientfacadeService")
public class ClientFacadeController {

    @Autowired
    private ClientFacadeFacade clientfacadeFacade;

    @PostMapping(value = "/sendOTP", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public SendOTPResponseBO sendOTP(@RequestBody SendOTPRequestBO request) {
        log.info("Clientfacade::sendOTP");
        return clientfacadeFacade.sendOTP(request);
    }

}
