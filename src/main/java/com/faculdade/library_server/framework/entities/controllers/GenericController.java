package com.faculdade.library_server.framework.entities.controllers;

import com.faculdade.library_server.framework.entities.domain.GenericEntity;
import com.faculdade.library_server.framework.entities.repositories.GenericRepository;
import com.faculdade.library_server.framework.entities.repositories.GenericValidatorRepository;
import com.faculdade.library_server.framework.entities.service.GenericService;
import com.faculdade.library_server.framework.entities.service.GenericValidator;
import lombok.Getter;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Getter
@Configurable(preConstruction = true, autowire = Autowire.BY_TYPE)
public class GenericController
        <   Type extends GenericEntity,
            Service extends GenericService< Type, Repository, ValidatorRepository, Validator>,
            Repository extends GenericRepository<Type>,
            ValidatorRepository extends GenericValidatorRepository<Type>,
            Validator extends GenericValidator<Type, ValidatorRepository>> {

    @Autowired private Service service;

    @GetMapping("{dataId}")
    public ResponseEntity<Type> read(@PathVariable UUID dataId){
        Type data = service.read(dataId);
        return ResponseEntity.ok(data);
    }

    @PostMapping
    public ResponseEntity<Type> create(@RequestBody Type inputData){
        Type data = service.save(inputData);

        if(data != null) {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(data);
        }
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(data);
    }

    @PutMapping("{dataId}")
    public ResponseEntity<Type> update(@PathVariable UUID dataId, @RequestBody Type inputData){
        Type currentData = service.read(dataId);
        BeanUtils.copyProperties(inputData, currentData, "id", "created");
        Type update = service.save(currentData);
        return ResponseEntity.ok(update);
    }

    @GetMapping("list")
    public ResponseEntity<List<Type>> list(@RequestBody(required = false) Map json){
        Specification filters = getFilters(json);
        return ResponseEntity.ok(service.listAll(filters));
    }

    public Specification getFilters(Map json){
        return null;
    }

}
