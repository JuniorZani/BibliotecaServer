package com.faculdade.library_server.business.emprestimo.services;

import com.faculdade.library_server.business.emprestimo.domain.Emprestimo;
import com.faculdade.library_server.business.emprestimo.repositories.EmprestimoValidatorRepository;
import com.faculdade.library_server.business.item.services.ItemValidator;
import com.faculdade.library_server.business.locatario.services.LocatarioValidator;
import com.faculdade.library_server.framework.entities.service.GenericValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class EmprestimoValidator extends GenericValidator<Emprestimo, EmprestimoValidatorRepository>{

    @Autowired private LocatarioValidator locatarioValidator;

    @Autowired private ItemValidator itemValidator;

    public boolean emprestar(UUID itemId, UUID locatarioId) {
        locatarioValidator.validateExistence(locatarioId);
        itemValidator.validateExistence(itemId);
        return true;
    }
}
