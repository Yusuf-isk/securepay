package com.demo.securepay.securepay.service;

import com.demo.securepay.dao.CustomerRepository;
import com.demo.securepay.dao.PaymentRepository;
import com.demo.securepay.entitiy.CustomerEntity;
import com.demo.securepay.entitiy.PaymentsEntity;
import com.demo.securepay.request.PaymentRequest;
import com.demo.securepay.request.SearchByDatePaymentsRequest;
import com.demo.securepay.request.SearchPaymentRequest;
import com.demo.securepay.service.dto.PaymentDto;
import com.demo.securepay.service.impl.CustomerServiceImpl;
import com.demo.securepay.service.impl.PaymentServiceImpl;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PaymentServiceTest {
    private CustomerRepository customerRepository;
    private PaymentRepository paymentRepository;
    PaymentServiceImpl paymentService;

    @BeforeEach
    public void setUp() {
        paymentRepository = mock(PaymentRepository.class);
        customerRepository = mock(CustomerRepository.class);
        paymentService = new PaymentServiceImpl(paymentRepository,customerRepository);
    }

    @Test
    public void testCreatePayments() {
        PaymentRequest paymentRequest = new PaymentRequest();
        paymentRequest.setDate(Date.from(Instant.now()));
        paymentRequest.setAmount(100.00);
        PaymentsEntity paymentsEntity = new PaymentsEntity();
        paymentsEntity.setAmount(100.00);
        when(paymentRepository.save(any())).thenReturn(paymentsEntity);
        PaymentDto payments = paymentService.createPayments(paymentRequest);
        Assertions.assertEquals(payments.getAmount(),paymentsEntity.getAmount());
    }

    @Test
    public void testSearchPaymentsByDate() {
        SearchByDatePaymentsRequest searchByDatePaymentsRequest = new SearchByDatePaymentsRequest();
        searchByDatePaymentsRequest.setStartDate(Date.from(Instant.now()));
        searchByDatePaymentsRequest.setEndDate(Date.from(Instant.now()));
        when(paymentRepository.findByDateBetween(any(),any())).thenReturn(new ArrayList<>());
        List<PaymentDto> paymentDtos = paymentService.searchPaymentsByDate(searchByDatePaymentsRequest);
        Assertions.assertNotNull(paymentDtos);
    }

    @Test
    public void testSearchPayments() {
        SearchPaymentRequest searchPaymentRequest = new SearchPaymentRequest();
        searchPaymentRequest.setCreditCardNumber("1231312");
        PaymentsEntity paymentsEntity = new PaymentsEntity();
        paymentsEntity.setAmount(0.0);
        when(customerRepository.findByCreditCardNumberIgnoreCase(any())).thenReturn(new CustomerEntity());
        when(paymentRepository.findByCreditCardNumber(any())).thenReturn(paymentsEntity);
        PaymentDto paymentDto = paymentService.searchPayment(searchPaymentRequest);
        Assertions.assertEquals(paymentDto.getAmount(),paymentsEntity.getAmount());
    }
}
