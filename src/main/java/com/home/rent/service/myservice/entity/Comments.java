package com.home.rent.service.myservice.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Comments extends Base {

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    private User commenter;

    @ManyToOne(fetch = FetchType.LAZY)
    private Property property;

    @OneToMany
    private Set<Reply> reply = new HashSet<>();

    private String text;
    private Date date;
}
