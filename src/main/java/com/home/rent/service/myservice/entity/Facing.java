package com.home.rent.service.myservice.entity;


import com.home.rent.service.myservice.enums.EFacing;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "facing")
public class Facing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private EFacing name;

}
