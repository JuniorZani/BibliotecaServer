package com.faculdade.library_server.business.emprestimo.specification;

import com.faculdade.library_server.business.emprestimo.domain.Emprestimo;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class EmprestimoSpecification {

    public static Specification<Emprestimo> statusSpecification(Object status){
        if(status != null)
            return (emprestimo, queue, builder) -> builder.equal(emprestimo.get("status"), status);
        return null;
    }

}
