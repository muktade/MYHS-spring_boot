package com.home.rent.service.myservice.repository;


import com.home.rent.service.myservice.entity.Reply;
import com.home.rent.service.myservice.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReplyRepository extends JpaRepository<Reply, Long> {

    @Query("SELECT r FROM Reply r WHERE r.id IN (:ids)")
    Page<Reply> getByIds(@Param("ids") List<Long> ids, Pageable pageable);
}
