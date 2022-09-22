package com.home.rent.service.myservice.entity;


import com.home.rent.service.myservice.enums.EPaymentFrequence;
import com.home.rent.service.myservice.enums.ERole;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "payment_frequence")
public class PaymentFrequence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private EPaymentFrequence name;

}
