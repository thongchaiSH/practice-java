package com.data.jpaexa.controller;

import com.data.jpaexa.dto.CustomerDetailsDTO;
import com.data.jpaexa.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping(value = "/customers",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CustomerDetailsDTO> getCustomers()throws Exception{
        return customerService.getCustomersAndOrderData();
    }
}
