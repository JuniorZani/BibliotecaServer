package com.faculdade.library_server.business.emprestimo.services;

import com.faculdade.library_server.business.emprestimo.domain.Emprestimo;
import com.faculdade.library_server.business.emprestimo.repositories.EmprestimoValidatorRepository;
import com.faculdade.library_server.business.item.domain.ItemStatus;
import com.faculdade.library_server.business.item.services.ItemService;
import com.faculdade.library_server.business.item.services.ItemValidator;
import com.faculdade.library_server.business.locatario.services.LocatarioValidator;
import com.faculdade.library_server.framework.entities.service.GenericValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class EmprestimoValidator extends GenericValidator<Emprestimo, EmprestimoValidatorRepository>{

    @Autowired private ItemValidator itemValidator;
    @Autowired private ItemService itemService;

    @Autowired private LocatarioValidator locatarioValidator;

    public void emprestar(UUID itemId, UUID locatarioId) {
        //Verificando se o item existe
        itemValidator.validateByType(itemId, ItemStatus.DISPONIVEL);

        //Verificando se o item não está esgotado
        itemValidator.validateByQuantity(itemId);

        //Verificando se o locatario existe
        locatarioValidator.validateExistence(locatarioId);

    }
}
