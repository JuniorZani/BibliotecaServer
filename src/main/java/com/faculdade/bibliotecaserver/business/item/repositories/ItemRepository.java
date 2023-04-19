package com.faculdade.bibliotecaserver.business.item.repositories;

import com.faculdade.bibliotecaserver.business.item.domain.Item;
import com.faculdade.bibliotecaserver.framework.entities.repositories.GenericRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ItemRepository extends GenericRepository<Item> {
}
