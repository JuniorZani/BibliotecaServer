package com.faculdade.library_server.business.emprestimo.repositories;

import com.faculdade.library_server.business.emprestimo.domain.Emprestimo;
import com.faculdade.library_server.framework.entities.repositories.GenericRepository;
import com.faculdade.library_server.framework.entities.repositories.GenericValidatorRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmprestimoValidatorRepository extends GenericValidatorRepository<Emprestimo> {
}
