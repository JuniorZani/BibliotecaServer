package com.faculdade.library_server.business.item.services;

import com.faculdade.library_server.business.item.domain.Item;
import com.faculdade.library_server.business.item.repositories.ItemValidatorRepository;
import com.faculdade.library_server.framework.entities.service.GenericValidator;
import org.springframework.stereotype.Service;

@Service
public class ItemValidator extends GenericValidator<Item, ItemValidatorRepository> {
}
