package com.faculdade.library_server.business.locador.services;

import com.faculdade.library_server.business.locador.domain.Locador;
import com.faculdade.library_server.business.locador.repositories.LocadorRepository;
import com.faculdade.library_server.business.locador.repositories.LocadorValidatorRepository;
import com.faculdade.library_server.framework.entities.service.GenericService;
import com.faculdade.library_server.framework.exceptions.access.SignInFailException;
import com.faculdade.library_server.framework.exceptions.access.SignUpFailException;
import com.faculdade.library_server.framework.exceptions.entity.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class LocadorService extends GenericService<Locador, LocadorRepository, LocadorValidatorRepository, LocadorValidator> {

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
    public Locador create(Locador data) {
        boolean locadorExists = getRepository().existsByLogin(data.getLogin());
        if(locadorExists){
            throw new SignUpFailException(LOGIN_INDISPONIVEL);
        }
        return super.create(data);
    }

    @Override
    public Locador update(Locador data){
        boolean locadorExists = getRepository().existsByLoginAndIdIsNot(data.getLogin(), data.getId());
        if(locadorExists){
            throw new SignUpFailException(LOGIN_INDISPONIVEL);
        }
        return super.update(data);
    }
}
