package com.faculdade.bibliotecaserver.framework.entities.controllers;

import com.faculdade.bibliotecaserver.framework.entities.domain.GenericEntity;
import com.faculdade.bibliotecaserver.framework.entities.repositories.GenericRepository;
import com.faculdade.bibliotecaserver.framework.entities.service.GenericService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@Configurable(preConstruction = true, autowire = Autowire.BY_TYPE)
public class GenericController
        <   Type extends GenericEntity,
            Service extends GenericService< Type, Repository>,
            Repository extends GenericRepository<Type>> {

    @Autowired private Service typeService;

    @GetMapping("{dataId}")
    public ResponseEntity<Type> read(@PathVariable UUID dataId){
        Type data = typeService.read(dataId);

        if(data == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(data);
    }

    @PostMapping
    public ResponseEntity<Type> create(@RequestBody Type inputData){
        Type data = typeService.save(inputData);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(data);
    }

    @PutMapping("{dataId}")
    public ResponseEntity<Type> update(@PathVariable UUID dataId, @RequestBody Type inputData){
        Type currentData = typeService.read(dataId);
        if(currentData == null){
            return ResponseEntity.notFound().build();
        }
        BeanUtils.copyProperties(inputData, currentData, "id");
        Type update = typeService.save(currentData);
        return ResponseEntity.ok(update);
    }

}
