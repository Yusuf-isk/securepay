package com.demo.securepay.securepay.controller;

import com.demo.securepay.controller.CustomerController;
import com.demo.securepay.controller.PaymentController;
import com.demo.securepay.request.PaymentRequest;
import com.demo.securepay.request.SearchByDatePaymentsRequest;
import com.demo.securepay.request.SearchPaymentRequest;
import com.demo.securepay.service.dto.PaymentDto;
import com.demo.securepay.service.impl.CustomerServiceImpl;
import com.demo.securepay.service.impl.PaymentServiceImpl;
import jakarta.persistence.ManyToOne;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class PaymentControllerTest {
    private PaymentServiceImpl paymentService;
    PaymentController paymentController;

    @BeforeEach
    public void setUp() {
        paymentService = mock(PaymentServiceImpl.class);
        paymentController = new PaymentController(paymentService);
    }

    @Test
    public void testCreatePayments() {
        PaymentRequest paymentRequest = new PaymentRequest();
        paymentRequest.setAmount(100.00);
        paymentRequest.setDate(Date.valueOf(LocalDate.now()));
        when(paymentService.searchPayment(any())).thenReturn(new PaymentDto());
        ResponseEntity<PaymentDto> payments = paymentController.createPayments(paymentRequest);
        Assertions.assertNotNull(payments);
    }

    @Test
    public void testSearchPayments() {
        SearchPaymentRequest searchPaymentRequest = new SearchPaymentRequest();
        searchPaymentRequest.setCreditCardNumber("12121221");
        when(paymentService.searchPayment(any())).thenReturn(new PaymentDto());
        ResponseEntity<PaymentDto> paymentDtoResponseEntity = paymentController.searchPayments(searchPaymentRequest);
        Assertions.assertNotNull(paymentDtoResponseEntity);

    }
    @Test
    public void testSearchDatePayments() {
        SearchByDatePaymentsRequest searchPaymentRequest = new SearchByDatePaymentsRequest();
        searchPaymentRequest.setEndDate(Date.valueOf(LocalDate.MAX));
        searchPaymentRequest.setStartDate(Date.valueOf(LocalDate.MIN));
        when(paymentService.searchPaymentsByDate(any())).thenReturn(new ArrayList<>());
        ResponseEntity<List<PaymentDto>> listResponseEntity = paymentController.searchDatePayments(searchPaymentRequest);
        Assertions.assertNotNull(listResponseEntity);

    }
}
