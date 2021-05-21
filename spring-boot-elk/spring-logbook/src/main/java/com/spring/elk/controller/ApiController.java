package com.spring.elk.controller;

import com.spring.elk.model.ResponseBo;
import com.spring.elk.service.PetService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1")
public class ApiController {

    @Autowired
    PetService petService;

    @GetMapping("/")
    public String home() {
        log.info("Home controller");
        return "example";
    }

    @GetMapping("/employee")
    public ResponseBo index() {
        return ResponseBo.builder().status("0").message("200").build();
    }

    @GetMapping("/fail")
    public ResponseBo fail() {
        throw new RuntimeException("test");
    }

    @GetMapping("/fail500")
    public ResponseEntity fail500() {
        return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PostMapping("/fail")
    public ResponseBo post() {
        return petService.test();
    }
}
