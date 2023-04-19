package com.faculdade.bibliotecaserver.business.locador.services;

import com.faculdade.bibliotecaserver.business.locador.domain.Locador;
import com.faculdade.bibliotecaserver.business.locador.repositories.LocadorRepository;
import com.faculdade.bibliotecaserver.framework.entities.service.GenericService;
import com.faculdade.bibliotecaserver.framework.exceptions.access.SignInFailException;
import com.faculdade.bibliotecaserver.framework.exceptions.access.SignUpFailException;
import com.faculdade.bibliotecaserver.framework.exceptions.entity.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class LocadorService extends GenericService<Locador, LocadorRepository> {

    private static String LOCADOR_NAO_ENCONTRADO = "Locador não encontrado";

    private static String CREDENCIAIS_INCORRETAS = "Verifique os campos e tente novamente";

    private static String LOGIN_INDISPONIVEL = "Login indisponível. Tente outro ou verifique se já tem uma conta no sistema";

    public UUID signIn(String login, String senha){
        Locador locador = getRepository().findLocadorByLogin(login);
        if(locador == null){
            throw new EntityNotFoundException(LOCADOR_NAO_ENCONTRADO);
        }
        if(!senha.equals(locador.getSenha())){
            throw new SignInFailException(CREDENCIAIS_INCORRETAS);
        }
        return locador.getId();
    }

    @Override
    public Locador save(Locador data) {
        boolean locadorExists = getRepository().existsByLogin(data.getLogin());
        if(locadorExists){
            throw new SignUpFailException(LOGIN_INDISPONIVEL);
        }
        return super.save(data);
    }
}
