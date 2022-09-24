package com.home.rent.service.myservice.repository;

import com.home.rent.service.myservice.entity.Area;
import com.home.rent.service.myservice.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AreaRepository extends JpaRepository<Area, Long> {

    @Query("SELECT a FROM Area a WHERE a.id IN (:ids)")
    Page<Area> getByIds(@Param("ids") List<Long> ids, Pageable pageable);

}
