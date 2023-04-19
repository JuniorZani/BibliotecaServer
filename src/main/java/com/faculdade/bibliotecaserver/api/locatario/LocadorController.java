package com.faculdade.bibliotecaserver.api.locatario;

import com.faculdade.bibliotecaserver.business.locador.domain.Locador;
import com.faculdade.bibliotecaserver.business.locador.repositories.LocadorRepository;
import com.faculdade.bibliotecaserver.business.locador.services.LocadorService;
import com.faculdade.bibliotecaserver.framework.controllers.GenericController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("locadores")
public class LocadorController extends GenericController<Locador, LocadorService, LocadorRepository> {

}
