package com.home.rent.service.myservice.controller;

import com.home.rent.service.myservice.entity.ChatHistory;
import com.home.rent.service.myservice.exceptions.ResourceNotFoundException;
import com.home.rent.service.myservice.service.ChatHistoryService;
import com.home.rent.service.myservice.utils.PageUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.transaction.Transactional;

@Controller
@Transactional
@RequestMapping("/chatHistory")
@RequiredArgsConstructor
public class ChatHistoryController implements BaseController<ChatHistory, Long> {

    @Autowired
    private final ChatHistoryService chatHistoryService;

    @Override
    public ResponseEntity<ChatHistory> save(@RequestBody ChatHistory chatHistory) {
        chatHistoryService.save(chatHistory);
        return ResponseEntity.ok(chatHistory);
    }

    @Override
    public ResponseEntity<String> update(@RequestBody ChatHistory chatHistory) {
        return null;
    }

    @Override
    public ResponseEntity<ChatHistory> getById(@PathVariable("id") Long id) throws ResourceNotFoundException {

//        chatHistoryService.getByIds(Pageable.ofSize(10), id);
        return null;
    }



    @Override
    public ResponseEntity<Page<ChatHistory>> getByIds(@PathVariable("ids") Long... ids) {
        Page<ChatHistory> chatHistories = chatHistoryService.getByIds(Pageable.ofSize(10),ids);
        return ResponseEntity.ok(chatHistories);
    }

    @Override
    public ResponseEntity<?> deleteByIds(@PathVariable("ids") Long... ids) {
        chatHistoryService.deleteByIds(ids);
        return ResponseEntity.ok("chat delete success");
    }

    @Override
    public ResponseEntity<Page<ChatHistory>> getAll(@PathVariable(value = "pageNumber",required = false) Integer pageNumber,
                                                    @PathVariable(value = "pageSize",required = false) Integer pageSize,
                                                    @PathVariable(value = "sortDirection",required = false) String sortDirection) {
       Pageable pageable = PageUtils.getPageable(pageNumber,pageSize,sortDirection);
       Page<ChatHistory> chatHistories = chatHistoryService.getAll(pageable);
        return ResponseEntity.ok(chatHistories);
    }

    @GetMapping("chatByUser/{userId}")
    public ResponseEntity<Page<ChatHistory>> getByUserId(@PathVariable("userId") Long id){
        Page<ChatHistory> chatHistories = chatHistoryService.getByUserId(Pageable.ofSize(10), id);
        return ResponseEntity.ok(chatHistories);
    }
}
