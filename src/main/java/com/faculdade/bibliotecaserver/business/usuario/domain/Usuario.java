package com.faculdade.bibliotecaserver.business.usuario.domain;


import com.faculdade.bibliotecaserver.framework.entities.GenericEntity;
import lombok.Data;

import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass
public class Usuario extends GenericEntity {

    private String login;

    private String senha;

}
