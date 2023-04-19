package com.faculdade.bibliotecaserver.business.item.domain;

import com.faculdade.bibliotecaserver.framework.entities.domain.GenericEntity;
import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class Item extends GenericEntity {

    private String descricao;

}
