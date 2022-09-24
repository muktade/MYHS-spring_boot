package com.home.rent.service.myservice.serviceImpl;

import com.home.rent.service.myservice.entity.ChatHistory;
import com.home.rent.service.myservice.exceptions.InvalidOperationException;
import com.home.rent.service.myservice.repository.ChatHistoryRepository;
import com.home.rent.service.myservice.service.ChatHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
@RequiredArgsConstructor
public class ChatHistoryImpl implements ChatHistoryService {


    private final ChatHistoryRepository chatHistoryRepository;

    @Override
    public ChatHistory save(ChatHistory chatHistory) {
        return chatHistoryRepository.save(chatHistory);
    }

    @Override
    public ChatHistory update(ChatHistory chatHistory) throws Exception {

        if(chatHistory.hasId()){
            return update(chatHistory);
        }else {
            throw new InvalidOperationException("Chat History is not found");
        }
    }

    @Override
    public Page<ChatHistory> getByIds(Pageable pageable, Long... ids) {
        if(ids == null && ids.length<1){
            return getAll(pageable);
        }else {
            return getByIds(pageable, ids);
        }
    }

    @Override
    public Page<ChatHistory> getAll(Pageable pageable) {
        return getAll(pageable);
    }

    @Override
    public void deleteByIds(Long... ids) {
        chatHistoryRepository.deleteAllByIdInBatch(Arrays.asList(ids));
    }
}
