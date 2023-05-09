package com.faculdade.library_server.business.emprestimo.repositories;

import com.faculdade.library_server.business.emprestimo.domain.Emprestimo;
import com.faculdade.library_server.business.emprestimo.domain.EmprestimoStatus;
import com.faculdade.library_server.framework.entities.repositories.GenericRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.UUID;

@Repository
public interface EmprestimoRepository extends GenericRepository<Emprestimo> {

    @Modifying
    @Transactional
    @Query("UPDATE Emprestimo e " +
            "SET e.quantidade = e.quantidade - :quantidade, e.status = :status " +
            "WHERE e.id = :emprestimoId")
    void updateStatusAndQuantidadeById(UUID emprestimoId, Integer quantidade, EmprestimoStatus status);
}
