package com.faculdade.library_server.business.locador.repositories;

import com.faculdade.library_server.business.locador.domain.Locador;
import com.faculdade.library_server.framework.entities.repositories.GenericRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LocadorRepository extends GenericRepository<Locador> {
    Locador findLocadorByLogin(String login);
    boolean existsByLogin(String login);
    boolean existsByLoginAndIdIsNot(String login, UUID userId);

}
