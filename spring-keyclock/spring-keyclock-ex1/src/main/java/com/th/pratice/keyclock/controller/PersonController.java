package com.th.pratice.keyclock.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    @GetMapping("/test")
    public String test(){
        return "Hello";
    }
}
