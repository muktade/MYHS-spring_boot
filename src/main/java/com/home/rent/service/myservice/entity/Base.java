package com.home.rent.service.myservice.entity;


import javax.persistence.*;

@MappedSuperclass
public class Base {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Boolean isActive;

    private Boolean isApproved;

    public boolean hasId() {
        return id != null && id > 0;
    }
}
