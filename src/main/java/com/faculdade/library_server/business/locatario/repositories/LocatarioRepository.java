package com.faculdade.library_server.business.locatario.repositories;

import com.faculdade.library_server.business.locatario.domain.Locatario;
import com.faculdade.library_server.framework.entities.repositories.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocatarioRepository extends GenericRepository<Locatario> {
}
