package com.faculdade.library_server.business.emprestimo.controller;

import com.faculdade.library_server.business.emprestimo.domain.Emprestimo;
import com.faculdade.library_server.business.emprestimo.repositories.EmprestimoRepository;
import com.faculdade.library_server.business.emprestimo.repositories.EmprestimoValidatorRepository;
import com.faculdade.library_server.business.emprestimo.services.EmprestimoService;
import com.faculdade.library_server.business.emprestimo.services.EmprestimoValidator;
import com.faculdade.library_server.framework.entities.controllers.GenericController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("emprestimos")
public class EmprestimoController extends GenericController<Emprestimo, EmprestimoService, EmprestimoRepository, EmprestimoValidatorRepository, EmprestimoValidator> {

    @PostMapping("emprestar")
    public ResponseEntity<Emprestimo> emprestar(@RequestBody Map<String, String> json){
        UUID itemId = UUID.fromString(json.get("itemId"));
        UUID locatarioId = UUID.fromString(json.get("locatarioId"));

        Emprestimo emprestimo = getService().emprestar(itemId, locatarioId);
        return ResponseEntity.ok(emprestimo);
    }

}
