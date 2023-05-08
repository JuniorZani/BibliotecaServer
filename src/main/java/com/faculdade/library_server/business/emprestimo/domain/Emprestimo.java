package com.faculdade.library_server.business.emprestimo.domain;

import com.faculdade.library_server.business.item.domain.Item;
import com.faculdade.library_server.business.locatario.domain.Locatario;
import com.faculdade.library_server.framework.entities.domain.GenericEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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
    private Item item;

    @NotNull
    @OneToOne
    @JoinColumn
    private Locatario locatario;
}
