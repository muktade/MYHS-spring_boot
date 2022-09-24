package com.home.rent.service.myservice.controller;


import com.home.rent.service.myservice.entity.Reply;
import com.home.rent.service.myservice.entity.User;
import com.home.rent.service.myservice.exceptions.ResourceNotFoundException;
import com.home.rent.service.myservice.service.ReplyService;
import com.home.rent.service.myservice.service.UserService;
import com.home.rent.service.myservice.utils.PageUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.transaction.Transactional;

@Controller
@RequestMapping("/reply/")
@RequiredArgsConstructor
@Transactional
public class ReplyController implements BaseController<Reply, Long> {

    private final ReplyService replyService;

    @Override
    public ResponseEntity<Reply> save(@RequestBody Reply reply) {
        System.out.println(reply);
        replyService.save(reply);
        return ResponseEntity.ok(reply);
    }

    @Override
    public ResponseEntity<String> update(@RequestBody Reply reply) {

        try {
            replyService.update(reply);
            return ResponseEntity.ok("Reply Is Up To Date");
        }catch (Exception e){
            return ResponseEntity.unprocessableEntity()
                    .body(e.getMessage());
        }
    }

    @Override
    public ResponseEntity<Reply> getById(@PathVariable("id") Long id) throws ResourceNotFoundException {
        return null;
    }

    @Override
    public ResponseEntity<Page<Reply>> getByIds(@PathVariable("ids") Long... ids) {

        Page<Reply> replys = replyService.getByIds(Pageable.ofSize(10),ids);

        return ResponseEntity.ok(replys);
    }

    @Override
    public ResponseEntity<String > deleteByIds(@PathVariable("ids") Long... ids) {
        replyService.deleteByIds(ids);
        return ResponseEntity.ok("User Deleted Succesfully");
    }

    @Override
    public ResponseEntity<Page<User>> getAll(
            @PathVariable(value = "pageNumber", required = false) Integer pageNumber,
            @PathVariable(value = "pageSize", required = false) Integer pageSize,
            @PathVariable(value = "sortDirection", required = false) String sortDirection) {

        Pageable pageable = PageUtils.getPageable(pageNumber, pageSize, sortDirection, "id");
        Page<User> page = replyService.getAll(pageable);

        return ResponseEntity.ok(page);
    }
}
