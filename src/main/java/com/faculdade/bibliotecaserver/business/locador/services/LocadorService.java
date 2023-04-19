package com.faculdade.bibliotecaserver.business.locador.services;

import com.faculdade.bibliotecaserver.business.locador.domain.Locador;
import com.faculdade.bibliotecaserver.business.locador.repositories.LocadorRepository;
import com.faculdade.bibliotecaserver.framework.service.GenericService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class LocadorService extends GenericService<Locador, LocadorRepository> {

    public UUID signIn(String login, String senha){
        Locador locador = getRepository().findLocadorByLogin(login);


        return null;
    }
}
