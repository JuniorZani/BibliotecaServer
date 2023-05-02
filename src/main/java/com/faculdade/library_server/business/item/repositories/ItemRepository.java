package com.faculdade.library_server.business.item.repositories;

import com.faculdade.library_server.business.item.domain.Item;
import com.faculdade.library_server.framework.entities.repositories.GenericRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ItemRepository extends GenericRepository<Item> {
}
