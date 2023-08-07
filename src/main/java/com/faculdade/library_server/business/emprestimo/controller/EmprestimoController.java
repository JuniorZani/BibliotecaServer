package com.faculdade.library_server.business.emprestimo.controller;

import com.faculdade.library_server.business.emprestimo.domain.Emprestimo;
import com.faculdade.library_server.business.emprestimo.input_model.EmprestimoInput;
import com.faculdade.library_server.business.emprestimo.repositories.EmprestimoRepository;
import com.faculdade.library_server.business.emprestimo.repositories.EmprestimoValidatorRepository;
import com.faculdade.library_server.business.emprestimo.services.EmprestimoService;
import com.faculdade.library_server.business.emprestimo.services.EmprestimoValidator;
import com.faculdade.library_server.business.emprestimo.specification.EmprestimoSpecification;
import com.faculdade.library_server.framework.entities.controllers.GenericController;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("emprestimos")
public class EmprestimoController extends GenericController<Emprestimo, EmprestimoService, EmprestimoRepository,
        EmprestimoValidatorRepository, EmprestimoValidator> {

    @PostMapping("emprestar")
    public ResponseEntity<Emprestimo> emprestar(@RequestBody EmprestimoInput emprestimoInput){
        UUID itemId = UUID.fromString(emprestimoInput.getItemId());
        UUID locatarioId = UUID.fromString(emprestimoInput.getLocatarioId());

        Emprestimo emprestimo = getService().emprestar(itemId, locatarioId, emprestimoInput.getQuantidade());
        return ResponseEntity.ok(emprestimo);
    }

    @PostMapping("devolver/{dataId}")
    public ResponseEntity<Emprestimo> devolver(@PathVariable UUID dataId, @RequestBody Map<String, Integer> json){
        Integer quantidade = json.get("quantidade");
        Emprestimo emprestimo = getService().devolver(dataId, quantidade);
        return ResponseEntity.ok(emprestimo);
    }

    @Override
    public Specification setFilters(Map json, List<String> ignoredFields) {
        if(json.isEmpty()){
            return null;
        }
        if(json.containsKey("status")) {
            return EmprestimoSpecification.statusSpecification(json.get("status"))
                    .and(super.setFilters(json, Arrays.asList("status")));
        }
        return null;
    }
}
