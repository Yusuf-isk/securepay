package com.demo.securepay.securepay.service;

import com.demo.securepay.dao.CustomerRepository;
import com.demo.securepay.entitiy.CustomerEntity;
import com.demo.securepay.request.CustomerRequest;
import com.demo.securepay.service.dto.CustomerDto;
import com.demo.securepay.service.impl.CustomerServiceImpl;
import com.demo.securepay.service.impl.PaymentServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;

public class CustomerServiceTest {
    private CustomerRepository customerRepository;
    CustomerServiceImpl customerService;

    @BeforeEach
    public void setUp() {
        customerRepository = mock(CustomerRepository.class);
        customerService = new CustomerServiceImpl(customerRepository);
    }

    @Test
    public void testCreateCustomer() {
        CustomerRequest customerRequest = new CustomerRequest();
        customerRequest.setAddress("FOooo foooo foooooooooo");
        customerRequest.setName("John");
        customerRequest.setAddress("Doe");
        customerRequest.setEmail("John@securepay.com");
        customerRequest.setPhoneNumber("0538 885 65 48");
        customerRequest.setCreditCardNumber("1542 5481 2455 8744");
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setName("John");
        Mockito.when(customerRepository.save(any())).thenReturn(customerEntity);
        CustomerDto customer = customerService.createCustomer(customerRequest);
        Assertions.assertEquals(customer.getName(),customerEntity.getName());
    }
    @Test
    public void testCreateCustomerThrowException() {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setName("John");
        Mockito.when(customerRepository.save(any())).thenThrow(NullPointerException.class);
        CustomerDto customer = customerService.createCustomer(null);
    }
}
