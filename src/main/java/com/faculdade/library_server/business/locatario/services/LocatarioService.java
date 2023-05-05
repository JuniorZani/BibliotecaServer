package com.faculdade.library_server.business.locatario.services;

import com.faculdade.library_server.business.locador.domain.Locador;
import com.faculdade.library_server.business.locador.services.LocadorService;
import com.faculdade.library_server.business.locatario.domain.Locatario;
import com.faculdade.library_server.business.locatario.repositories.LocatarioRepository;
import com.faculdade.library_server.framework.entities.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class LocatarioService extends GenericService<Locatario, LocatarioRepository> {

    @Autowired private LocadorService locadorService;

    @Override
    public Locatario create(Locatario data) {
        Locador locador = data.getLocador();
        locadorService.read(locador);
        return super.create(data);
    }
}
