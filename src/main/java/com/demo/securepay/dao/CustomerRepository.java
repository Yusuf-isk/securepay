package com.demo.securepay.dao;

import com.demo.securepay.entitiy.CustomerEntity;
import com.demo.securepay.request.CustomerRequest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<CustomerEntity, Long> {
    CustomerEntity save(CustomerEntity customerEntity);

    CustomerEntity findByCreditCardNumberIgnoreCase(String creditCardNumber);

}
