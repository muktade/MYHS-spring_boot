package com.home.rent.service.myservice.repository;


import com.home.rent.service.myservice.entity.Property;
import com.home.rent.service.myservice.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PropertyRepository extends JpaRepository<Property, Long> {

    @Query("SELECT p FROM Property p WHERE p.id IN (:ids)")
    Page<Property> getByIds(@Param("ids") List<Long> ids, Pageable pageable);

    @Query("SELECT p FROM Property p where p.propertyType = (:propertyType)")
    Page<Property> getByPropertyType(@Param("propertyType") String propertyType,
                                     Pageable pageable);



}
