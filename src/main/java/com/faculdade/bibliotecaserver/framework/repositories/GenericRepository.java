package com.faculdade.bibliotecaserver.framework.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.UUID;

@NoRepositoryBean
public interface GenericRepository<Type> extends JpaRepository<Type, UUID> {

}
