package com.demo.securepay.dao;

import com.demo.securepay.entitiy.PaymentsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<PaymentsEntity,Long> {
    PaymentsEntity findByCreditCardNumber(String creditCardNumber);

    @Query("select p from PaymentsEntity p where p.date between ?1 and ?2")
    List<PaymentsEntity> findByDateBetween(Date dateStart, Date dateEnd);

}
