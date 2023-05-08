package com.faculdade.library_server.framework.entities.service;

import com.faculdade.library_server.framework.entities.domain.GenericEntity;
import com.faculdade.library_server.framework.entities.repositories.GenericValidatorRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

import javax.persistence.EntityNotFoundException;
import java.lang.reflect.ParameterizedType;
import java.util.UUID;

@Getter
@Configurable(preConstruction = true, autowire = Autowire.BY_TYPE)
public abstract class GenericValidator
        < Type extends GenericEntity,
        Repository extends GenericValidatorRepository<Type>> {

    @Autowired Repository repository;

    Class<Type> typeClass = null;
    public GenericValidator(){
        this.typeClass = (Class<Type>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public void validateExistence(UUID dataId){
        boolean exists = getRepository().existsById(dataId);
        if(!exists){
            throw new EntityNotFoundException(String.format("%s não encontrado(a)", typeClass.getSimpleName()));
        }
    }
}
