package com.demo.securepay.service.mapper;

import com.demo.securepay.entitiy.CustomerEntity;
import com.demo.securepay.service.dto.CustomerDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerDtoMapper {
    CustomerDtoMapper INSTANCE = Mappers.getMapper(CustomerDtoMapper.class);
    CustomerDto customerDtoToCustomerEntity(CustomerEntity customerEntity);
}
