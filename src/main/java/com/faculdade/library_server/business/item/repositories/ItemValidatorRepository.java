package com.faculdade.library_server.business.item.repositories;

import com.faculdade.library_server.business.item.domain.Item;
import com.faculdade.library_server.framework.entities.repositories.GenericValidatorRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ItemValidatorRepository extends GenericValidatorRepository<Item> {
}
