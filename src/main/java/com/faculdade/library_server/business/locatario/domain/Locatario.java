package com.faculdade.library_server.business.locatario.domain;

import com.faculdade.library_server.business.locador.domain.Locador;
import com.faculdade.library_server.framework.entities.domain.GenericEntity;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@Entity
public class Locatario extends GenericEntity {

    @NotBlank
    @Length(max = 50)
    private String nome;

    @Column(length = 11)
    @Length(max = 11, min = 10)
    private String telefone;

    @JsonIncludeProperties("id")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, updatable = false)
    private Locador locador;

}
