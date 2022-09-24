package com.home.rent.service.myservice.controller;


import com.home.rent.service.myservice.entity.City;
import com.home.rent.service.myservice.entity.User;
import com.home.rent.service.myservice.exceptions.ResourceNotFoundException;
import com.home.rent.service.myservice.service.CityService;
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
@RequestMapping("/city/")
@RequiredArgsConstructor
@Transactional
public class CityController implements BaseController<City, Long> {

    private final CityService cityService;

    @Override
    public ResponseEntity<City> save(@RequestBody City city) {
        System.out.println(city);
        cityService.save(city);
        return ResponseEntity.ok(city);
    }

    @Override
    public ResponseEntity<String> update(@RequestBody City city) {

        try {
            cityService.update(city);
            return ResponseEntity.ok("City Is Up To Date");
        }catch (Exception e){
            return ResponseEntity.unprocessableEntity()
                    .body(e.getMessage());
        }
    }

    @Override
    public ResponseEntity<City> getById(Long id) throws ResourceNotFoundException {
        return null;
    }

    @Override
    public ResponseEntity<Page<City>> getByIds(@PathVariable("ids") Long... ids) {

        Page<City> citys = cityService.getByIds(Pageable.ofSize(10),ids);

        return ResponseEntity.ok(citys);
    }

    @Override
    public ResponseEntity<String > deleteByIds(@PathVariable("ids") Long... ids) {
        cityService.deleteByIds(ids);
        return ResponseEntity.ok("City Deleted Succesfully");
    }

    @Override
    public ResponseEntity<Page<City>> getAll(
            @PathVariable(value = "pageNumber", required = false) Integer pageNumber,
            @PathVariable(value = "pageSize", required = false) Integer pageSize,
            @PathVariable(value = "sortDirection", required = false) String sortDirection) {

        Pageable pageable = PageUtils.getPageable(pageNumber, pageSize, sortDirection, "id");
        Page<City> page = cityService.getAll(pageable);

        return ResponseEntity.ok(page);
    }
}
