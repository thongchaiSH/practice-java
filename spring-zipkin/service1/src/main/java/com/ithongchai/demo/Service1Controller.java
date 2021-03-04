package com.ithongchai.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.annotation.NewSpan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class Service1Controller {

    private static Logger log = LoggerFactory.getLogger(Service1Controller.class);

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/hi")
    public String hi(){
        log.info("Before send..");
        return  this.restTemplate.getForEntity("http://localhost:8081/service2/hi",String.class).getBody();
    }

    @NewSpan
    @GetMapping(value = "/sleep/{time}")
    public ResponseEntity sleep(@PathVariable int time){
        try {
            log.info("Before send..");
            Thread.sleep(time);
            log.info("After send..");
            return new ResponseEntity(HttpStatus.OK);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
