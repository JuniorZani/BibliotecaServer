package com.faculdade.bibliotecaserver.business.locador.services;

import com.faculdade.bibliotecaserver.business.locador.domain.Locador;
import com.faculdade.bibliotecaserver.business.locador.repositories.LocadorRepository;
import com.faculdade.bibliotecaserver.framework.entities.service.GenericService;
import com.faculdade.bibliotecaserver.framework.exceptions.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class LocadorService extends GenericService<Locador, LocadorRepository> {

    private static String LOCADOR_NAO_ENCONTRADO = "Locador não encontrado";

    public UUID signIn(String login, String senha){
        Locador locador = getRepository().findLocadorByLogin(login);
        if(locador == null){
            throw new EntityNotFoundException(LOCADOR_NAO_ENCONTRADO);
        }

        return null;
    }
}
