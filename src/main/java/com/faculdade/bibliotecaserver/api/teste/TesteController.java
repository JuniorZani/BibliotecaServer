package com.faculdade.bibliotecaserver.api.teste;

import com.faculdade.bibliotecaserver.business.locador.domain.Locador;
import com.faculdade.bibliotecaserver.business.locador.services.LocadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("pedro")
public class TesteController {

    @Autowired LocadorService locadorService;

//    @PostMapping
//    public ResponseEntity save(@RequestBody Locador data){
//        Locador locador =  locadorService.save(data);
//        return ResponseEntity.ok(locador);
//    }


}
