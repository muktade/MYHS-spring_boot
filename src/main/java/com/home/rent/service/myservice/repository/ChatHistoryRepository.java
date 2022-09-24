package com.home.rent.service.myservice.repository;

import com.home.rent.service.myservice.entity.ChatHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatHistoryRepository extends JpaRepository<ChatHistory, Long> {
}
