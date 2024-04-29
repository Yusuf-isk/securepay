package com.demo.securepay.service.dto;

import lombok.Data;

import java.util.Date;

@Data
public class PaymentSearchDto {
    private double amount;
    private Date date;
    private String creditCardNumber;
    private String name;
    private String surname;
}
