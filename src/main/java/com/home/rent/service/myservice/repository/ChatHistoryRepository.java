package com.home.rent.service.myservice.repository;

import com.home.rent.service.myservice.entity.ChatHistory;
import com.home.rent.service.myservice.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatHistoryRepository extends JpaRepository<ChatHistory, Long> {

    @Query("SELECT c FROM ChatHistory c WHERE c.fromUserId = (:id)")
    Page<ChatHistory> getBySentUserId(@Param("id") Long id, Pageable pageable);
}
