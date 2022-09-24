package com.home.rent.service.myservice.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "city")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    private District district;

    public boolean hasId() {

        return id != null && id >0;
    }
}
