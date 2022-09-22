package com.home.rent.service.myservice.entity;


import com.home.rent.service.myservice.enums.EDivision;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "division")
public class Division {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private EDivision division;

    private String name;

}
