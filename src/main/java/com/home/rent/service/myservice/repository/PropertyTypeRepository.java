package com.home.rent.service.myservice.repository;


import com.home.rent.service.myservice.entity.PropertyType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PropertyTypeRepository extends JpaRepository<PropertyType, Long> {

    @Query("SELECT p FROM PropertyType p WHERE p.id IN (:ids)")
    Page<PropertyType> getByIds(@Param("ids") List<Long> ids, Pageable pageable);
}
