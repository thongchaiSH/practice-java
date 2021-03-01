package com.example.test.service;


import com.example.test.model.Bear;
import org.springframework.beans.factory.annotation.Autowired;

public class BearService {
//    @Autowired
    Bear bear;
    public BearService(Bear bear){
        this.bear=bear;
    }

    public String say(){
        return  bear.roar();
    }
}
