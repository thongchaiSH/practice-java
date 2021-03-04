package com.ithongchai.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Service2Controller {

    private static Logger log = LoggerFactory.getLogger(Service2Controller.class);

    @GetMapping("/hi")
    public String hi(){
        log.info("Before send..");
        return "Hello";
    }


}
