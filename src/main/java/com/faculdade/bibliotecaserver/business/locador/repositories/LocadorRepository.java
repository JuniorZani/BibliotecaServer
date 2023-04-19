package com.faculdade.bibliotecaserver.business.locador.repositories;

import com.faculdade.bibliotecaserver.business.locador.domain.Locador;
import com.faculdade.bibliotecaserver.framework.entities.repositories.GenericRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LocadorRepository extends GenericRepository<Locador> {
    Locador findLocadorByLogin(String login);
    boolean existsByLogin(String login);
    boolean existsByLoginAndIdIsNot(String login, UUID userId);

}
