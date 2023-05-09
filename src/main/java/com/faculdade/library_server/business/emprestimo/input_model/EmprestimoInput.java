package com.faculdade.library_server.business.emprestimo.input_model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmprestimoInput {

    private String itemId;

    private String locatarioId;

    private Integer quantidade;
}
