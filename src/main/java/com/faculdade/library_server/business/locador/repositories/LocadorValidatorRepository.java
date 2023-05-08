package com.faculdade.library_server.business.locador.repositories;

import com.faculdade.library_server.business.locador.domain.Locador;
import com.faculdade.library_server.framework.entities.repositories.GenericValidatorRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocadorValidatorRepository extends GenericValidatorRepository<Locador> {

}
