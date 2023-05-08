package com.faculdade.library_server.business.item.repositories;

import com.faculdade.library_server.business.item.domain.Item;
import com.faculdade.library_server.business.item.domain.ItemStatus;
import com.faculdade.library_server.framework.entities.repositories.GenericValidatorRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface ItemValidatorRepository extends GenericValidatorRepository<Item> {

    boolean existsByIdAndStatus(UUID itemId, ItemStatus status);

    boolean existsByIdAndQuantidadeGreaterThan(UUID itemId, Integer quantity);

}
