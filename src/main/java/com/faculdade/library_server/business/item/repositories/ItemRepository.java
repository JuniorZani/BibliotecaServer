package com.faculdade.library_server.business.item.repositories;

import com.faculdade.library_server.business.item.domain.Item;
import com.faculdade.library_server.business.item.domain.ItemStatus;
import com.faculdade.library_server.framework.entities.repositories.GenericRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface ItemRepository extends GenericRepository<Item> {

    @Query("UPDATE Item i " +
            "SET i.status = :status " +
            "WHERE i.id = :itemId")
    void updateStatusById(UUID itemId, ItemStatus status);

}
