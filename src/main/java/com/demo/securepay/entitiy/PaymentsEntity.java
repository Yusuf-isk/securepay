package com.demo.securepay.entitiy;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "TBL_PAYMENTS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class PaymentsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Min(message = "must be greater than zero", value = 1)
    @Column(nullable = false)
    private double amount;
    private Date date;
    private String creditCardNumber;
    @ManyToOne
    @JoinColumn(name = "customer_id",referencedColumnName = "id")
    private CustomerEntity customer;
}
