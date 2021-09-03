package com.data.jpaexa.service;

import com.data.jpaexa.dto.CustomerDetailsDTO;

import java.util.List;

public interface CustomerService {

    List<CustomerDetailsDTO> getCustomersAndOrderData() throws Exception;

    List<CustomerDetailsDTO> searchCustomerByFirstName(String firstName) throws  Exception;
}
