package com.faculdade.library_server.framework.entities;

import com.faculdade.library_server.business.emprestimo.domain.Emprestimo;
import org.springframework.data.jpa.domain.Specification;

public class GenericSpecification {

    public static Specification genericSpecification(Object search, String property){
        if(search != null)
            return (object, queue, builder) -> builder.equal(object.get(property), search);
        return null;
    }
}
