package com.demo.securepay.service.mapper;

import com.demo.securepay.entitiy.CustomerEntity;
import com.demo.securepay.request.CustomerRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerEntityMapper {
    CustomerEntityMapper INSTANCE = Mappers.getMapper(CustomerEntityMapper.class);
    CustomerEntity customerRequestToCustomerEntity(CustomerRequest customerRequest);
}
