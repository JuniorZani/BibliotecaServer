package com.faculdade.library_server.business.emprestimo.services;

import com.faculdade.library_server.business.emprestimo.domain.Emprestimo;
import com.faculdade.library_server.business.emprestimo.repositories.EmprestimoValidatorRepository;
import com.faculdade.library_server.business.item.domain.ItemStatus;
import com.faculdade.library_server.business.item.services.ItemValidator;
import com.faculdade.library_server.business.locatario.services.LocatarioValidator;
import com.faculdade.library_server.framework.entities.service.GenericValidator;
import com.faculdade.library_server.framework.exceptions.entity.EntityException;
import com.faculdade.library_server.framework.exceptions.entity.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class EmprestimoValidator extends GenericValidator<Emprestimo, EmprestimoValidatorRepository>{

    @Autowired private ItemValidator itemValidator;

    @Autowired private LocatarioValidator locatarioValidator;

    private final static String QUANTIDADE_INVALIDA = "Quantidade inválida, tente novamente com um valor maior que zero";
    private final static String QUANTIDADE_EMPRESTIMO_INVALIDA = "Quantidade inválida, verifique a quantidade emprestada e tente novamente";


    public void emprestar(UUID itemId, UUID locatarioId, ItemStatus status, Integer quantidade) {

        if(quantidade <= 0){
            throw new EntityException(QUANTIDADE_INVALIDA);
        }

        //Verificando se o item existe
        itemValidator.validateByType(itemId, status);

        //Verificando se o item não está esgotado
        itemValidator.validateByQuantity(itemId, quantidade);

        //Verificando se o locatario existe
        locatarioValidator.validateExistence(locatarioId);
    }

    public void devolver(UUID emprestimoId, Integer quantidade) {
        if(quantidade <= 0){
            throw new EntityException(QUANTIDADE_INVALIDA);
        }
        //Verificando se o emprestimo existe
        validateExistence(emprestimoId);

        //Verificando a quantidade emprestada
        validateExistenceByQuantidade(emprestimoId, quantidade);
    }

    public void validateExistenceByQuantidade(UUID dataId, Integer quantidade) {
        boolean exists = getRepository().existsByIdAndQuantidade(dataId, quantidade);
        if(!exists){
            throw new EntityException(QUANTIDADE_EMPRESTIMO_INVALIDA);
        }
    }
}
