package com.faculdade.bibliotecaserver.api.locador;

import com.faculdade.bibliotecaserver.business.locador.domain.Locador;
import com.faculdade.bibliotecaserver.business.locador.repositories.LocadorRepository;
import com.faculdade.bibliotecaserver.business.locador.services.LocadorService;
import com.faculdade.bibliotecaserver.framework.controllers.GenericController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("locadores")
public class LocadorController extends GenericController<Locador, LocadorService, LocadorRepository> {

    @Autowired LocadorService locadorService;

    @PostMapping("sign-in")
    public ResponseEntity signIn(@RequestBody Locador locador){
        UUID uuid = locadorService.signIn(locador.getLogin(), locador.getSenha());

        return ResponseEntity.ok(uuid);
    }

}
