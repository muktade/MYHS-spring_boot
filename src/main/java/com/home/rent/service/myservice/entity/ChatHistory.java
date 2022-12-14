package com.home.rent.service.myservice.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class ChatHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long fromUserId;
//    fromUse_id;
//    touser_id;
    private String message;

    public boolean hasId() {
        return id != null && id >0;
    }
}
