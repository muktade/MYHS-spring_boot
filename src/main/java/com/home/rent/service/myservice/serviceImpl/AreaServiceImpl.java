package com.home.rent.service.myservice.serviceImpl;

import com.home.rent.service.myservice.entity.Area;
import com.home.rent.service.myservice.exceptions.InvalidOperationException;
import com.home.rent.service.myservice.repository.AreaRepository;
import com.home.rent.service.myservice.service.AreaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;


@Service
@RequiredArgsConstructor
public class AreaServiceImpl implements AreaService {


    @Autowired
    private final AreaRepository areaRepository;

    @Override
    public Area save(Area area) {
        return areaRepository.save(area);
    }

    @Override
    public Area update(Area area) throws Exception {
        if(area.hasId()){
            return save(area);
        }else {
            throw new InvalidOperationException("area is not found");
        }
    }

    @Override
    public Page<Area> getByIds(Pageable pageable, Long... ids) {
        if(ids == null && ids.length < 1){
            return getAll(pageable);
        }else {
            return areaRepository.getByIds(Arrays.asList(ids), pageable);
        }
    }

    @Override
    public Page<Area> getAll(Pageable pageable) {
        return areaRepository.findAll(pageable);
    }

    @Override
    public void deleteByIds(Long... ids) {
        areaRepository.deleteAllByIdInBatch(Arrays.asList(ids));
    }
}
