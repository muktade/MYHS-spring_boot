package com.home.rent.service.myservice.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "city")
public class Area {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    private District district;

    @Column(name = "post_code")
    private String postCode;

}
