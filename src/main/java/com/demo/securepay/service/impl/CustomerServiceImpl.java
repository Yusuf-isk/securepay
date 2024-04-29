package com.demo.securepay.service.impl;

import com.demo.securepay.dao.CustomerRepository;
import com.demo.securepay.entitiy.CustomerEntity;
import com.demo.securepay.request.CustomerRequest;
import com.demo.securepay.service.CustomerService;
import com.demo.securepay.service.dto.CustomerDto;
import com.demo.securepay.service.mapper.CustomerDtoMapper;
import com.demo.securepay.service.mapper.CustomerEntityMapper;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {
    Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);
    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public CustomerDto createCustomer(CustomerRequest customerRequest) {
        try {
            CustomerEntity entity = CustomerEntityMapper.INSTANCE.customerRequestToCustomerEntity(customerRequest);
            CustomerEntity customerEntity = customerRepository.save(entity);
            CustomerDto customerDto = CustomerDtoMapper.INSTANCE.customerDtoToCustomerEntity(customerEntity);
            return customerDto;
        } catch (Exception exception) {
            logger.error(exception.getMessage());
        }
        return new CustomerDto();
    }
}
