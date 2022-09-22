package com.home.rent.service.myservice.serviceImpl;

import com.home.rent.service.myservice.entity.Property;
import com.home.rent.service.myservice.exceptions.InvalidOperationException;
import com.home.rent.service.myservice.repository.PropertyRepository;
import com.home.rent.service.myservice.service.PropertyService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
@RequiredArgsConstructor
public class PropertyServiceImpl implements PropertyService {

    private final PropertyRepository propertyRepository;


    @Override
    public Page<Property> getByIds(Pageable pageable, Long... ids) {
        if(ids==null || (ids.length < 1)){
            return getAll(pageable);
        }else {
            return propertyRepository.getByIds(Arrays.asList(ids),
                    pageable);
        }
    }

    @Override
    public Page<Property> getAll(Pageable pageable) {

        return propertyRepository.findAll(pageable);
    }

    @Override
    public Property save(Property property) {
        return propertyRepository.save(property);
    }

    @Override
    public Property update(Property property) throws Exception {
        if(property.hasId()){
            return save(property);
        }else {
            throw  new InvalidOperationException("Property id not found");
        }
    }

    @Override
    public void deleteByIds(Long... ids) {
        propertyRepository.deleteAllByIdInBatch(Arrays.asList(ids));
    }

    @Override
    public Page<Property> getPropertyByPropertyType(String propertyType, Pageable pageable) {
        return propertyRepository.getByPropertyType(propertyType, pageable);
    }
}
