package com.faculdade.library_server.business.item.services;

import com.faculdade.library_server.business.item.domain.Item;
import com.faculdade.library_server.business.item.repositories.ItemRepository;
import com.faculdade.library_server.framework.entities.service.GenericService;
import org.springframework.stereotype.Service;

@Service
public class ItemService extends GenericService<Item, ItemRepository> {
}
