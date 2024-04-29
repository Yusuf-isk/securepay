package com.demo.securepay.service;

import com.demo.securepay.request.PaymentRequest;
import com.demo.securepay.request.SearchByDatePaymentsRequest;
import com.demo.securepay.request.SearchPaymentRequest;
import com.demo.securepay.service.dto.PaymentDto;

import java.util.List;

public interface PaymentService {
  PaymentDto createPayments(PaymentRequest paymentRequest);
  PaymentDto searchPayment(SearchPaymentRequest searchPaymentRequest);

  List<PaymentDto> searchPaymentsByDate(SearchByDatePaymentsRequest byDatePaymentsRequest);
}
