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

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import static com.faculdade.library_server.framework.entities.GenericSpecification.genericSpecification;

@Getter
@Configurable(preConstruction = true, autowire = Autowire.BY_TYPE)
public class GenericController
        <   Type extends GenericEntity,
            Service extends GenericService< Type, Repository, ValidatorRepository, Validator>,
            Repository extends GenericRepository<Type>,
            ValidatorRepository extends GenericValidatorRepository<Type>,
            Validator extends GenericValidator<Type, ValidatorRepository>> {

    @Autowired private Service service;

    Class<Type> typeClass = null;
    public GenericController(){
        this.typeClass = (Class<Type>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

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
    public ResponseEntity<List<Type>> list(@RequestBody(required = false) Map<Object,Object> json){
        Specification filters = setFilters(json, null);
        return ResponseEntity.ok(service.listAll(filters));
    }

    public Specification setFilters(Map json, List<String> ignoredFields){
        if(json == null) {
            return null;
        }
        Specification specification = null;
        List<Field> fields = Arrays.asList(typeClass.getDeclaredFields());

        if(ignoredFields != null){
            fields = fields.stream()
                    .filter(field -> !ignoredFields.contains(field.getName()))
                    .collect(Collectors.toList());
        }

        for(Field field : fields){
            if(json.containsKey(field.getName())){
                if(specification == null)
                    specification = genericSpecification(json.get(field.getName()), field.getName());
                else
                    specification = specification.and(genericSpecification(json.get(field.getName()), field.getName()));
            }
        }
        return specification;
    }

}
