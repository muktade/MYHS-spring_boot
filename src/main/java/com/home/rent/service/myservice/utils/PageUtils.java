package com.home.rent.service.myservice.utils;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class PageUtils {

    public static Pageable getPageable(int pageNumber, int pageSize, String sortDirection, String... sortFields){
        Sort.Direction direction = Sort.Direction.fromString(sortDirection);
        Sort sort = Sort.by(direction, sortFields);
        return PageRequest.of(pageNumber, pageSize, sort);
    }
}

