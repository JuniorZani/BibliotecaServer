package com.faculdade.bibliotecaserver.business.usuario.domain;


import com.faculdade.bibliotecaserver.framework.entities.domain.GenericEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass
public class Usuario extends GenericEntity {

    @Column(unique = true)
    private String login;

    private String senha;

}
