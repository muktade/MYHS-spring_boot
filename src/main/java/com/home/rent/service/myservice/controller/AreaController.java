package com.home.rent.service.myservice.controller;

import com.home.rent.service.myservice.entity.Area;
import com.home.rent.service.myservice.exceptions.ResourceNotFoundException;
import com.home.rent.service.myservice.service.AreaService;
import com.home.rent.service.myservice.utils.PageUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

@RestController
@Transactional
@RequestMapping("/area/")
@RequiredArgsConstructor
public class AreaController implements BaseController<Area, Long>{

    @Autowired
    private final AreaService areaService;


    @Override
    public ResponseEntity<Area> save(@RequestBody Area area) {
        areaService.save(area);
        return ResponseEntity.ok(area);
    }

    @Override
    public ResponseEntity<String> update(@RequestBody Area area) {
        try {
            areaService.update(area);
            return ResponseEntity.ok("Area is Updated");
        } catch (Exception e) {
            return ResponseEntity.unprocessableEntity()
                    .body(e.getMessage());
        }
    }

    @Override
    public ResponseEntity<String> deleteByIds(@PathVariable("ids") Long... ids) {
        areaService.deleteByIds(ids);
        return ResponseEntity.ok("Area is Deleted");
    }

    @Override
    public ResponseEntity<Page<Area>> getAll(@PathVariable(value = "pageNumber" , required = false) Integer pageNumber,
                                             @PathVariable(value = "pageSize", required = false) Integer pageSize,
                                             @PathVariable(value = "sortDirection", required = false) String sortDirection) {
        Pageable pageable = PageUtils.getPageable(pageNumber,pageSize,sortDirection);
        Page<Area> page = areaService.getAll(pageable);
        return ResponseEntity.ok(page);
    }

    @Override
    public ResponseEntity<Page<Area>> getByIds(@PathVariable("ids") Long... ids) {
        Page<Area> page = areaService.getByIds(Pageable.ofSize(10), ids);
        return ResponseEntity.ok(page);
    }

    @Override
    public ResponseEntity<Area> getById(Long id) throws ResourceNotFoundException {
        return null;
    }
}
