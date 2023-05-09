package com.faculdade.library_server.business.emprestimo.domain;

import com.faculdade.library_server.business.item.domain.Item;
import com.faculdade.library_server.business.locatario.domain.Locatario;
import com.faculdade.library_server.framework.entities.domain.GenericEntity;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@Entity
@AllArgsConstructor
public class Emprestimo extends GenericEntity {

    @NotNull
    @OneToOne
    @JoinColumn
    @JsonIncludeProperties({"id", "nome"})
    private Item item;

    @NotNull
    @OneToOne
    @JoinColumn
    @JsonIncludeProperties({"id", "nome"})
    private Locatario locatario;

    @NotNull
    @Min(1)
    private Integer quantidade;

    @Enumerated(value = EnumType.STRING)
    private EmprestimoStatus status;
}
