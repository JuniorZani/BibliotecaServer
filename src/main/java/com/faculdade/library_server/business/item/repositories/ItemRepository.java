package com.faculdade.library_server.business.item.repositories;

import com.faculdade.library_server.business.item.domain.Item;
import com.faculdade.library_server.business.item.domain.ItemStatus;
import com.faculdade.library_server.framework.entities.repositories.GenericRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.UUID;


@Repository
public interface ItemRepository extends GenericRepository<Item> {

    @Modifying
    @Transactional
    @Query("UPDATE Item i " +
            "SET i.status = :status, i.quantidade = i.quantidade - :quantidade " +
            "WHERE i.id = :itemId")
    void updateStatusAndQuantidadeById(UUID itemId, ItemStatus status, Integer quantidade);

}
