package com.home.rent.service.myservice.serviceImpl;

import com.home.rent.service.myservice.entity.PropertyType;
import com.home.rent.service.myservice.entity.User;
import com.home.rent.service.myservice.exceptions.InvalidOperationException;
import com.home.rent.service.myservice.repository.PropertyTypeRepository;
import com.home.rent.service.myservice.repository.UserRepository;
import com.home.rent.service.myservice.service.PropertyTypeService;
import com.home.rent.service.myservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
@RequiredArgsConstructor
public class PropertyTypeServiceImpl implements PropertyTypeService {

    private final PropertyTypeRepository propertyTypeRepository;

    @Override
    public PropertyType save(PropertyType propertyType)  {

        return propertyTypeRepository.save(propertyType);
    }

    @Override
    public PropertyType update(PropertyType propertyType) throws Exception {
        if (propertyType.hasId()) {
            return save(propertyType);
        } else {
            throw new InvalidOperationException("PropertyType id required for update operation");
        }
    }

    @Override
    public Page<PropertyType> getByIds(Pageable pageable, Long... ids) {
        if(ids==null || (ids.length < 1)){
            return getAll(pageable);
        }else {
            return propertyTypeRepository.getByIds(Arrays.asList(ids),
                    pageable);
        }
    }

    @Override
    public Page<PropertyType> getAll(Pageable pageable) {

        return propertyTypeRepository.findAll(pageable);
    }

    @Override
    public void deleteByIds(Long... ids) {

        propertyTypeRepository.deleteAllByIdInBatch(Arrays.asList(ids));
    }
}
