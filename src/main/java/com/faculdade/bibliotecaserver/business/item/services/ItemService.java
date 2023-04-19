package com.faculdade.bibliotecaserver.business.item.services;

import com.faculdade.bibliotecaserver.business.item.domain.Item;
import com.faculdade.bibliotecaserver.business.item.repositories.ItemRepository;
import com.faculdade.bibliotecaserver.framework.entities.service.GenericService;
import org.springframework.stereotype.Service;

@Service
public class ItemService extends GenericService<Item, ItemRepository> {
}
