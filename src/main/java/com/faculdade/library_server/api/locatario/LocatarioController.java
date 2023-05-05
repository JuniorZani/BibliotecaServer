package com.faculdade.library_server.api.locatario;

import com.faculdade.library_server.business.locatario.domain.Locatario;
import com.faculdade.library_server.business.locatario.repositories.LocatarioRepository;
import com.faculdade.library_server.business.locatario.services.LocatarioService;
import com.faculdade.library_server.framework.entities.controllers.GenericController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("locatarios")
public class LocatarioController extends GenericController<Locatario, LocatarioService, LocatarioRepository> {

}
