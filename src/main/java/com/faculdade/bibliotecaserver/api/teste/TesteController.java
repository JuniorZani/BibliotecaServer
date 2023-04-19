package com.faculdade.bibliotecaserver.api.teste;

import com.faculdade.bibliotecaserver.business.locador.services.LocadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("pedro")
public class TesteController {

    @Autowired LocadorService locadorService;

}
