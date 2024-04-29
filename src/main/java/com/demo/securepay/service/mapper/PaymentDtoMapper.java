package com.demo.securepay.service.mapper;

import com.demo.securepay.entitiy.PaymentsEntity;
import com.demo.securepay.service.dto.PaymentDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PaymentDtoMapper {
    PaymentDtoMapper INSTANCE = Mappers.getMapper(PaymentDtoMapper.class);

    PaymentDto paymentsEntityToPaymentDto(PaymentsEntity paymentsEntity);

    List<PaymentDto> listPaymentsEntityToPaymentDto(List<PaymentsEntity> paymentsEntity);
}
