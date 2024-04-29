package com.demo.securepay.service.mapper;

import com.demo.securepay.entitiy.PaymentsEntity;
import com.demo.securepay.request.PaymentRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface PaymentEntityMapper {
    PaymentEntityMapper INSTANCE = Mappers.getMapper(PaymentEntityMapper.class);
    PaymentsEntity paymentRequestToPaymentsEntity(PaymentRequest paymentRequest);
}
