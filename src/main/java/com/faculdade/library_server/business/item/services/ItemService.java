package com.faculdade.library_server.business.item.services;

import com.faculdade.library_server.business.item.domain.Item;
import com.faculdade.library_server.business.item.domain.ItemStatus;
import com.faculdade.library_server.business.item.repositories.ItemRepository;
import com.faculdade.library_server.business.item.repositories.ItemValidatorRepository;
import com.faculdade.library_server.framework.entities.service.GenericService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ItemService extends GenericService<Item, ItemRepository, ItemValidatorRepository, ItemValidator> {
    public Item emprestar(UUID itemId) {
        getRepository().updateStatusAndQuantidadeById(itemId);
        return read(itemId);
    }
}
