package com.faculdade.bibliotecaserver.framework.service;

import com.faculdade.bibliotecaserver.framework.entities.GenericEntity;
import com.faculdade.bibliotecaserver.framework.repositories.GenericRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

import java.util.UUID;

@Getter
@Configurable(preConstruction = true, autowire = Autowire.BY_TYPE)
public abstract class GenericService
        <   Type extends GenericEntity,
            Repository extends GenericRepository<Type>> {

    @Autowired private Repository repository;

    public Type save(Type data){
        return repository.save(data);
    }

    public Type read(UUID dataId){
        return repository.findById(dataId).orElse(null);
    }
}
