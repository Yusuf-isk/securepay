package com.demo.securepay.controller;

import com.demo.securepay.service.dto.CustomerDto;
import com.demo.securepay.request.CustomerRequest;
import com.demo.securepay.service.impl.CustomerServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@Tag(name = "Customer")
public class CustomerController {
    private final CustomerServiceImpl customerService;

    public CustomerController(CustomerServiceImpl customerService) {
        this.customerService = customerService;
    }

    @PostMapping(value = "/save/customer", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CustomerDto> createCustomer(@RequestBody CustomerRequest customerRequest) {
        CustomerDto customer = customerService.createCustomer(customerRequest);
        return ResponseEntity.ok().body(customer);

    }
}
