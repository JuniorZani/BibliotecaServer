package com.faculdade.bibliotecaserver.api.item;

import com.faculdade.bibliotecaserver.business.item.domain.Item;
import com.faculdade.bibliotecaserver.business.item.repositories.ItemRepository;
import com.faculdade.bibliotecaserver.business.item.services.ItemService;
import com.faculdade.bibliotecaserver.framework.entities.controllers.GenericController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("itens")
public class ItemController extends GenericController<Item, ItemService, ItemRepository> {
}
