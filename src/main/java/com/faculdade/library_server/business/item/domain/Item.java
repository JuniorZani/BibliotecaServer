package com.faculdade.library_server.business.item.domain;

import com.faculdade.library_server.framework.entities.domain.GenericEntity;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class Item extends GenericEntity {

    @NotBlank
    private String nome;

    @NotNull
    @Min(0)
    private Integer quantidade;

    @Length(max = 400)
    private String descricao;
}
