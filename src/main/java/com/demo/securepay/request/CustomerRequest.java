package com.demo.securepay.request;

import lombok.Data;

@Data
public class CustomerRequest {
    private String name;
    private String surname;
    private String address;
    private String phoneNumber;
    private String email;
    private String creditCardNumber;
}
