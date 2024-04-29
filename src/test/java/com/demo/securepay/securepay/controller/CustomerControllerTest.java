package com.demo.securepay.securepay.controller;

import com.demo.securepay.controller.CustomerController;
import com.demo.securepay.request.CustomerRequest;
import com.demo.securepay.service.dto.CustomerDto;
import com.demo.securepay.service.impl.CustomerServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CustomerControllerTest {
    private CustomerServiceImpl customerService;
    CustomerController customerController;

    @BeforeEach
    public void setUp() {
        customerService = Mockito.mock(CustomerServiceImpl.class);
        customerController = new CustomerController(customerService);
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
        Mockito.when(customerService.createCustomer(customerRequest)).thenReturn(new CustomerDto());
        ResponseEntity<CustomerDto> customer = customerController.createCustomer(customerRequest);
        assertNotNull(customer);
    }
}
