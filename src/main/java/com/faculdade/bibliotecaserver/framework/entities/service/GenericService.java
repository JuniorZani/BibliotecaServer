package com.faculdade.bibliotecaserver.framework.entities.service;

import com.faculdade.bibliotecaserver.framework.entities.domain.GenericEntity;
import com.faculdade.bibliotecaserver.framework.entities.repositories.GenericRepository;
import com.faculdade.bibliotecaserver.framework.exceptions.EntityNotFoundException;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

import java.lang.reflect.ParameterizedType;
import java.util.UUID;

@Getter
@Configurable(preConstruction = true, autowire = Autowire.BY_TYPE)
public abstract class GenericService
        <   Type extends GenericEntity,
            Repository extends GenericRepository<Type>> {

    @Autowired private Repository repository;

    Class<Type> typeClass = null;
    public GenericService(){
        this.typeClass = (Class<Type>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public Type save(Type data){
        return repository.save(data);
    }

    public Type read(UUID dataId){
        return repository.findById(dataId)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Recurso %s não encontrado", typeClass.getSimpleName())));
    }
}
