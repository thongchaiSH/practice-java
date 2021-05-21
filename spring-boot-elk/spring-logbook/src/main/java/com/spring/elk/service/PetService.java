package com.spring.elk.service;

import com.spring.elk.model.ResponseBo;
import org.springframework.stereotype.Service;

@Service
public class PetService {
    public  ResponseBo test(){
        throw new IllegalArgumentException("TEST");
    }
}
