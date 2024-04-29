package com.demo.securepay.controller;

import com.demo.securepay.request.CustomerRequest;
import com.demo.securepay.request.PaymentRequest;
import com.demo.securepay.request.SearchByDatePaymentsRequest;
import com.demo.securepay.request.SearchPaymentRequest;
import com.demo.securepay.service.dto.PaymentDto;
import com.demo.securepay.service.impl.PaymentServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/")
@Tag(name = "Payments")
public class PaymentController {
    private final PaymentServiceImpl paymentService;

    public PaymentController(PaymentServiceImpl paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping(value = "/save/payments", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PaymentDto> createPayments(@RequestBody PaymentRequest paymentRequest) {
        PaymentDto payments = paymentService.createPayments(paymentRequest);
        return ResponseEntity.ok().body(payments);

    }
    @PostMapping(value = "/search/payments", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PaymentDto> searchPayments(@RequestBody SearchPaymentRequest paymentRequest) {
        PaymentDto payments = paymentService.searchPayment(paymentRequest);
        return ResponseEntity.ok().body(payments);

    }
    @PostMapping(value = "/search/payments/date", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PaymentDto>> searchDatePayments(@RequestBody SearchByDatePaymentsRequest paymentRequest) {
        List<PaymentDto> paymentDtos = paymentService.searchPaymentsByDate(paymentRequest);
        return ResponseEntity.ok().body(paymentDtos);

    }

}
