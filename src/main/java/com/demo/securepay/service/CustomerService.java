package com.demo.securepay.service;

import com.demo.securepay.request.CustomerRequest;
import com.demo.securepay.service.dto.CustomerDto;

public interface CustomerService {
    public CustomerDto createCustomer(CustomerRequest customerRequest);
}
