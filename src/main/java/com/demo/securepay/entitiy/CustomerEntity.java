package com.demo.securepay.entitiy;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "TBL_CUSTOMER")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String surname;
    private String address;
    private String phoneNumber;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String creditCardNumber;
    @OneToMany(mappedBy = "customer")
    private List<PaymentsEntity> payments;
}
