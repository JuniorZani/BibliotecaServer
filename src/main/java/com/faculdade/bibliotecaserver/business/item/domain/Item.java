package com.faculdade.bibliotecaserver.business.item.domain;

import com.faculdade.bibliotecaserver.framework.entities.GenericEntity;

import javax.persistence.Entity;

@Entity
public class Item extends GenericEntity {

    private String descricao;

}
