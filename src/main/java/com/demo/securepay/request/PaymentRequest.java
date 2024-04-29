package com.demo.securepay.request;

import lombok.Data;

import java.util.Date;

@Data
public class PaymentRequest {
    private double amount;
    private Date date;
    private String creditCardNumber;
}
