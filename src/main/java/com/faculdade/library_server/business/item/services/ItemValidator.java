package com.faculdade.library_server.business.item.services;

import com.faculdade.library_server.business.item.domain.Item;
import com.faculdade.library_server.business.item.domain.ItemStatus;
import com.faculdade.library_server.business.item.repositories.ItemValidatorRepository;
import com.faculdade.library_server.framework.entities.service.GenericValidator;
import com.faculdade.library_server.framework.exceptions.entity.EntityException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ItemValidator extends GenericValidator<Item, ItemValidatorRepository> {

    private String STATUS_ITEM_INVALIDO = "Status do item inválido, para realizar a operação selecione um item %s";
    private String ITEM_ESGOTADO = "O item selecionado está esgotado";

    public void validateByType(UUID itemId, ItemStatus status){
        boolean existsByStatus = getRepository().existsByIdAndStatus(itemId, status);
        if(!existsByStatus){
            throw new EntityException(String.format(STATUS_ITEM_INVALIDO, ItemStatus.DISPONIVEL.toString().toLowerCase()));
        }
    }

    public void validateByQuantity(UUID itemId) {
        boolean esgotado = !getRepository().existsByIdAndQuantidadeGreaterThan(itemId, 0);
        if(esgotado){
            throw new EntityException(ITEM_ESGOTADO);
        }
    }
}
