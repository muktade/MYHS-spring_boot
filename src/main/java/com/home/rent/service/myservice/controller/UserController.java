package com.home.rent.service.myservice.controller;


import com.home.rent.service.myservice.entity.User;
import com.home.rent.service.myservice.exceptions.ResourceNotFoundException;
import com.home.rent.service.myservice.service.UserService;
import com.home.rent.service.myservice.utils.PageUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user/")
@RequiredArgsConstructor
public class UserController implements BaseController<User, Long> {

    private final UserService userService;

    @Override
    public ResponseEntity<User> save(User user) {
        userService.save(user);
        return ResponseEntity.ok(user);
    }

    @Override
    public ResponseEntity<String> update(@RequestBody User user) {

        try {
            userService.update(user);
            return ResponseEntity.ok("User Is Up To Date");
        }catch (Exception e){
            return ResponseEntity.unprocessableEntity()
                    .body(e.getMessage());
        }
    }

    @Override
    public ResponseEntity<User> getById(Long id) throws ResourceNotFoundException {
        return null;
    }

    @Override
    public ResponseEntity<Page<User>> getByIds(@PathVariable("ids") Long... ids) {

        Page<User> users = userService.getByIds(Pageable.ofSize(10),ids);

        return ResponseEntity.ok(users);
    }

    @Override
    public ResponseEntity<String > deleteByIds(@PathVariable("ids") Long... ids) {
        userService.deleteByIds(ids);
        return ResponseEntity.ok("User Deleted Succesfully");
    }

    @Override
    public ResponseEntity<Page<User>> getAll(
            @PathVariable(value = "pageNumber", required = false) Integer pageNumber,
            @PathVariable(value = "pageSize", required = false) Integer pageSize,
            @PathVariable(value = "sortDirection", required = false) String sortDirection) {

        Pageable pageable = PageUtils.getPageable(pageNumber, pageSize, sortDirection, "id");
        Page<User> page = userService.getAll(pageable);

        return ResponseEntity.ok(page);
    }
}
