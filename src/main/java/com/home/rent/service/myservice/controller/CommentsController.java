package com.home.rent.service.myservice.controller;


import com.home.rent.service.myservice.entity.Comments;
import com.home.rent.service.myservice.exceptions.ResourceNotFoundException;
import com.home.rent.service.myservice.service.CommentsService;
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
@RequestMapping("/comments/")
@RequiredArgsConstructor
@Transactional
public class CommentsController implements BaseController<Comments, Long> {

    private final CommentsService commentsService;

    @Override
    public ResponseEntity<Comments> save(@RequestBody Comments comment) {
        System.out.println(comment);
        commentsService.save(comment);
        return ResponseEntity.ok(comment);
    }

    @Override
    public ResponseEntity<String> update(@RequestBody Comments comment) {

        try {
            commentsService.update(comment);
            return ResponseEntity.ok("Comments Is Up To Date");
        }catch (Exception e){
            return ResponseEntity.unprocessableEntity()
                    .body(e.getMessage());
        }
    }

    @Override
    public ResponseEntity<Comments> getById(@PathVariable("id") Long id) throws ResourceNotFoundException {
        return null;
    }

    @Override
    public ResponseEntity<Page<Comments>> getByIds(@PathVariable("ids") Long... ids) {

        Page<Comments> comments = commentsService.getByIds(Pageable.ofSize(10),ids);

        return ResponseEntity.ok(comments);
    }

    @Override
    public ResponseEntity<String > deleteByIds(@PathVariable("ids") Long... ids) {
        commentsService.deleteByIds(ids);
        return ResponseEntity.ok("Comments Deleted Succesfully");
    }

    @Override
    public ResponseEntity<Page<Comments>> getAll(
            @PathVariable(value = "pageNumber", required = false) Integer pageNumber,
            @PathVariable(value = "pageSize", required = false) Integer pageSize,
            @PathVariable(value = "sortDirection", required = false) String sortDirection) {

        Pageable pageable = PageUtils.getPageable(pageNumber, pageSize, sortDirection, "id");
        Page<Comments> page = commentsService.getAll(pageable);

        return ResponseEntity.ok(page);
    }
}
