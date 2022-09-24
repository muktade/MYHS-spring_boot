package com.home.rent.service.myservice.service;

import com.home.rent.service.myservice.entity.ChatHistory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ChatHistoryService extends BaseService<ChatHistory, Long>{

     Page<ChatHistory> getByUserId(Pageable pageable, Long userId);
}
