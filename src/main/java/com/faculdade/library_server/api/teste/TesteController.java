package com.faculdade.library_server.api.teste;

import com.faculdade.library_server.business.locador.services.LocadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("pedro")
public class TesteController {

    @Autowired LocadorService locadorService;

}
