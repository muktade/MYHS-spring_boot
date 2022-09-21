package com.home.rent.service.myservice.entity;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class comments extends Base {

//    user_id;
//    property_id;
//    @OneToMany
//    private Set<Reply> reply = new HashSet<>();
    private String text;
    private Date date;
}
