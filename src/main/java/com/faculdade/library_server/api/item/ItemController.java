package com.faculdade.library_server.api.item;

import com.faculdade.library_server.business.item.domain.Item;
import com.faculdade.library_server.business.item.repositories.ItemRepository;
import com.faculdade.library_server.business.item.repositories.ItemValidatorRepository;
import com.faculdade.library_server.business.item.services.ItemService;
import com.faculdade.library_server.business.item.services.ItemValidator;
import com.faculdade.library_server.framework.entities.controllers.GenericController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("itens")
public class ItemController extends GenericController<Item, ItemService, ItemRepository, ItemValidatorRepository, ItemValidator> {

}
