package com.faculdade.library_server.business.item.domain;

import com.faculdade.library_server.business.locador.domain.Locador;
import com.faculdade.library_server.framework.entities.domain.GenericEntity;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@Entity
@AllArgsConstructor
public class Item extends GenericEntity {

    @NotBlank
    private String nome;

    @NotNull
    @Min(0)
    private Integer quantidade;

    @Length(max = 400)
    private String descricao;

    @JsonIncludeProperties("id")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(updatable = false, nullable = false)
    private Locador locador;

    @NotNull
    @Enumerated(value = EnumType.STRING)
    private ItemStatus status;
}
