package com.home.rent.service.myservice.controller;


import com.home.rent.service.myservice.entity.Property;
import com.home.rent.service.myservice.entity.User;
import com.home.rent.service.myservice.exceptions.ResourceNotFoundException;
import com.home.rent.service.myservice.service.PropertyService;
import com.home.rent.service.myservice.service.UserService;
import com.home.rent.service.myservice.utils.PageUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/property/")
@RequiredArgsConstructor
public class PropertyController implements BaseController<Property, Long> {

    private final PropertyService propertyService;

    @Override
    public ResponseEntity<Property> save(@RequestBody Property property) {
        propertyService.save(property);
        return ResponseEntity.ok(property);
    }

    @Override
    public ResponseEntity<String> update(@RequestBody Property property) {

        try {
            propertyService.update(property);
            return ResponseEntity.ok("Property Is Up To Date");
        }catch (Exception e){
            return ResponseEntity.unprocessableEntity()
                    .body(e.getMessage());
        }
    }

    @Override
    public ResponseEntity<Property> getById(Long id) throws ResourceNotFoundException {
        return null;
    }

    @Override
    public ResponseEntity<Page<Property>> getByIds(@PathVariable("ids") Long... ids) {

        Page<Property> propertys = propertyService.getByIds(Pageable.ofSize(10),ids);

        return ResponseEntity.ok(propertys);
    }

    @Override
    public ResponseEntity<String > deleteByIds(@PathVariable("ids") Long... ids) {
        propertyService.deleteByIds(ids);
        return ResponseEntity.ok("Property Deleted Succesfully");
    }

    @Override
    public ResponseEntity<Page<Property>> getAll(
            @PathVariable(value = "pageNumber", required = false) Integer pageNumber,
            @PathVariable(value = "pageSize", required = false) Integer pageSize,
            @PathVariable(value = "sortDirection", required = false) String sortDirection) {

        Pageable pageable = PageUtils.getPageable(pageNumber, pageSize, sortDirection, "id");
        Page<Property> page = propertyService.getAll(pageable);

        return ResponseEntity.ok(page);
    }

    @GetMapping("{propertyType}")
    public ResponseEntity<Page<Property>> getByPropertyType(
            @PathVariable("propertyType") String propertyType){
        Page<Property> propertys = propertyService.getPropertyByPropertyType(propertyType,Pageable.ofSize(10));

        return ResponseEntity.ok(propertys);
    }
}
