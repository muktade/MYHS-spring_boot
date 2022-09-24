package com.home.rent.service.myservice.serviceImpl;

import com.home.rent.service.myservice.entity.City;
import com.home.rent.service.myservice.exceptions.InvalidOperationException;
import com.home.rent.service.myservice.repository.CityRepository;
import com.home.rent.service.myservice.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;

    @Override
    public City save(City city)  {

        return cityRepository.save(city);
    }

    @Override
    public City update(City city) throws Exception {
        if (city.hasId()) {
            return save(city);
        } else {
            throw new InvalidOperationException("City id required for update operation");
        }
    }

    @Override
    public Page<City> getByIds(Pageable pageable, Long... ids) {
        if(ids==null || (ids.length < 1)){
            return getAll(pageable);
        }else {
            return cityRepository.getByIds(Arrays.asList(ids),
                    pageable);
        }
    }

    @Override
    public Page<City> getAll(Pageable pageable) {

        return cityRepository.findAll(pageable);
    }

    @Override
    public void deleteByIds(Long... ids) {

        cityRepository.deleteAllByIdInBatch(Arrays.asList(ids));
    }
}
