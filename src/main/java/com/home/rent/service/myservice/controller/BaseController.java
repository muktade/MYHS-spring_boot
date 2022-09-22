package com.home.rent.service.myservice.controller;

import com.home.rent.service.myservice.exceptions.ResourceNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;

import static org.springframework.http.MediaType.ALL_VALUE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

public interface BaseController<ENTITY, ID> {

    @PostMapping(value = "save", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    ResponseEntity<ENTITY> save(ENTITY entity);

    @PatchMapping(value = "update", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    ResponseEntity<String> update(ENTITY entity);

    @GetMapping(value = "get-by-id/{id}", produces = APPLICATION_JSON_VALUE)
    <T> ResponseEntity<T> getById(@Param("id") Long id) throws ResourceNotFoundException;

    @GetMapping(value = "list/{ids}", produces = APPLICATION_JSON_VALUE)
    <T> ResponseEntity<Page<T>> getByIds(ID... ids);

    @DeleteMapping(value = "delete/{ids}",produces = APPLICATION_JSON_VALUE)
    ResponseEntity<?> deleteByIds(ID... ids);

    @GetMapping(value = "page/{pageNumber}/{pageSize}/{sortDirection}", produces = APPLICATION_JSON_VALUE)
    <T> ResponseEntity<Page<T>> getAll(Integer pageNumber, Integer pageSize, String sortDirection);




}

