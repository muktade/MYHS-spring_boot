package com.home.rent.service.myservice.entity;


import com.home.rent.service.myservice.enums.EFacing;
import com.home.rent.service.myservice.enums.EPaymentFrequence;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Property extends Base {

    private String name;

    @OneToOne
    private PropertyType propertyType;
    private Double price;
    private String size;
//    private Photo[] photo;
    private EPaymentFrequence paymentFrequency;
    private String completionStatus;
    private Boolean isNagotiable;
    private String location;
    private EFacing facing;
    private String description;
    private Date publishDate;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;


}
