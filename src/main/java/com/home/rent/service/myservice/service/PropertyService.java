package com.home.rent.service.myservice.service;

import com.home.rent.service.myservice.entity.Property;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PropertyService extends BaseService<Property, Long> {

    Page<Property> getPropertyByPropertyType(String propertyType, Pageable pageable);

}
