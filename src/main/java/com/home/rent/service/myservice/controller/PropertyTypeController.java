package com.home.rent.service.myservice.controller;


import com.home.rent.service.myservice.entity.PropertyType;
import com.home.rent.service.myservice.entity.User;
import com.home.rent.service.myservice.exceptions.ResourceNotFoundException;
import com.home.rent.service.myservice.service.PropertyTypeService;
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
@RequestMapping("/propertyType/")
@RequiredArgsConstructor
@Transactional
public class PropertyTypeController implements BaseController<PropertyType, Long> {

    private final PropertyTypeService propertyTypeService;

    @Override
    public ResponseEntity<PropertyType> save(@RequestBody PropertyType propertyType) {
        System.out.println(propertyType);
        propertyTypeService.save(propertyType);
        return ResponseEntity.ok(propertyType);
    }

    @Override
    public ResponseEntity<String> update(@RequestBody PropertyType propertyType) {

        try {
            propertyTypeService.update(propertyType);
            return ResponseEntity.ok("PropertyType Is Up To Date");
        }catch (Exception e){
            return ResponseEntity.unprocessableEntity()
                    .body(e.getMessage());
        }
    }

    @Override
    public ResponseEntity<PropertyType> getById(@PathVariable("id") Long id) throws ResourceNotFoundException {
        return null;
    }

    @Override
    public ResponseEntity<Page<PropertyType>> getByIds(@PathVariable("ids") Long... ids) {

        Page<PropertyType> propertyTypes = propertyTypeService.getByIds(Pageable.ofSize(10),ids);

        return ResponseEntity.ok(propertyTypes);
    }

    @Override
    public ResponseEntity<String > deleteByIds(@PathVariable("ids") Long... ids) {
        propertyTypeService.deleteByIds(ids);
        return ResponseEntity.ok("PropertyType Deleted Succesfully");
    }

    @Override
    public ResponseEntity<Page<PropertyType>> getAll(
            @PathVariable(value = "pageNumber", required = false) Integer pageNumber,
            @PathVariable(value = "pageSize", required = false) Integer pageSize,
            @PathVariable(value = "sortDirection", required = false) String sortDirection) {

        Pageable pageable = PageUtils.getPageable(pageNumber, pageSize, sortDirection, "id");
        Page<PropertyType> page = propertyTypeService.getAll(pageable);

        return ResponseEntity.ok(page);
    }
}
