package com.home.rent.service.myservice.entity;


import lombok.Data;

import javax.persistence.Entity;
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
//    private Enum paymentFrequency;
    private String completionStatus;
    private Boolean isNagotiable;
    private String location;
//    private Enum facing;
    private String description;
    private Date publishDate;
//    user_id


}
