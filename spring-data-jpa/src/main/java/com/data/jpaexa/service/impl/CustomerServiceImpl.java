package com.data.jpaexa.service.impl;

import com.data.jpaexa.dto.CustomerDetailsDTO;
import com.data.jpaexa.entity.CustomerRepository;
import com.data.jpaexa.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<CustomerDetailsDTO> getCustomersAndOrderData() throws Exception {
        return customerRepository.getCustomerDetails();
    }

    @Override
    public List<CustomerDetailsDTO> searchCustomerByFirstName(String firstName) throws Exception {
        return customerRepository.searchCustomerByFirstName(firstName);
    }
}
