package com.faculdade.library_server.framework.entities.service;

import com.faculdade.library_server.framework.entities.domain.GenericEntity;
import com.faculdade.library_server.framework.entities.repositories.GenericRepository;
import com.faculdade.library_server.framework.entities.repositories.GenericValidatorRepository;
import com.faculdade.library_server.framework.exceptions.entity.EntityNotFoundException;
import com.faculdade.library_server.framework.exceptions.entity.EntityNotSendException;
import lombok.Getter;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.util.ObjectUtils;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.UUID;

@Getter
@Configurable(preConstruction = true, autowire = Autowire.BY_TYPE)
public abstract class GenericService
        <   Type extends GenericEntity,
            Repository extends GenericRepository<Type>,
            ValidatorRepository extends GenericValidatorRepository<Type>,
            Validator extends GenericValidator<Type, ValidatorRepository> > {

    @Autowired private Repository repository;

    @Autowired private Validator validator;

    Class<Type> typeClass = null;
    public GenericService(){
        this.typeClass = (Class<Type>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public Type save(Type data){
        if(ObjectUtils.isEmpty(data.getId())){
            return this.create(data);
        }
        return this.update(data);
    }

    public Type create(Type data){
        return repository.save(data);
    }
    public Type update(Type data){
        Type currentData = read(data.getId());
        BeanUtils.copyProperties(data, currentData, "created");
        repository.save(currentData);
        return read(data.getId());
    }

    public Type read(UUID dataId){
        return repository.findById(dataId)
                .orElseThrow(() -> new EntityNotFoundException(String.format("%s não encontrado(a)", typeClass.getSimpleName())));
    }

    public Type read(Type data){
        if(data == null){
            throw new EntityNotSendException(String.format("Campo %s não enviado", typeClass.getSimpleName()));
        } else {
            if(data.getId() == null){
                throw new EntityNotSendException(String.format("Campo %s.id não enviado", typeClass.getSimpleName().toLowerCase()));
            }
        }
        return read(data.getId());
    }

    public List<Type> list(){
        return getRepository().findAll();
    }
}
