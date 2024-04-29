package com.demo.securepay.service.impl;

import com.demo.securepay.dao.CustomerRepository;
import com.demo.securepay.dao.PaymentRepository;
import com.demo.securepay.entitiy.CustomerEntity;
import com.demo.securepay.entitiy.PaymentsEntity;
import com.demo.securepay.request.PaymentRequest;
import com.demo.securepay.request.SearchByDatePaymentsRequest;
import com.demo.securepay.request.SearchPaymentRequest;
import com.demo.securepay.service.PaymentService;
import com.demo.securepay.service.dto.PaymentDto;
import com.demo.securepay.service.mapper.PaymentDtoMapper;
import com.demo.securepay.service.mapper.PaymentEntityMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {
    Logger logger = LoggerFactory.getLogger(PaymentServiceImpl.class);
    private final PaymentRepository paymentRepository;
    private final CustomerRepository customerRepository;

    public PaymentServiceImpl(PaymentRepository paymentRepository, CustomerRepository customerRepository) {
        this.paymentRepository = paymentRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public PaymentDto createPayments(PaymentRequest paymentRequest) {
        try {

            CustomerEntity customerEntity = customerRepository.findByCreditCardNumberIgnoreCase(paymentRequest.getCreditCardNumber());
            PaymentsEntity paymentsEntity = PaymentEntityMapper.INSTANCE.paymentRequestToPaymentsEntity(paymentRequest);
            paymentsEntity.setCustomer(customerEntity);
            PaymentsEntity savedEntity = paymentRepository.save(paymentsEntity);
            PaymentDto paymentDto = PaymentDtoMapper.INSTANCE.paymentsEntityToPaymentDto(savedEntity);
            return paymentDto;
        } catch (Exception exception) {
            logger.error(exception.getMessage());
        }

        return new PaymentDto();
    }

    @Override
    public PaymentDto searchPayment(SearchPaymentRequest searchPaymentRequest) {
        try {
            PaymentsEntity byCreditCardNumber = paymentRepository.findByCreditCardNumber(searchPaymentRequest.getCreditCardNumber());
            if (byCreditCardNumber.getCustomer() == null){
                throw new RuntimeException("Customer Not Found");
            }
            PaymentDto paymentDto = PaymentDtoMapper.INSTANCE.paymentsEntityToPaymentDto(byCreditCardNumber);
            return paymentDto;
        } catch (Exception exception) {
            logger.error(exception.getMessage());
        }
        return new PaymentDto();
    }

    @Override
    public List<PaymentDto> searchPaymentsByDate(SearchByDatePaymentsRequest byDatePaymentsRequest) {
        try {
            List<PaymentsEntity> byDateBetween = paymentRepository
                    .findByDateBetween(byDatePaymentsRequest.getStartDate(), byDatePaymentsRequest.getEndDate());
            List<PaymentDto> paymentDtos = PaymentDtoMapper.INSTANCE.listPaymentsEntityToPaymentDto(byDateBetween);
            return paymentDtos;
        } catch (Exception exception) {
            logger.error(exception.getMessage());
        }

        return new ArrayList<>();
    }
}
