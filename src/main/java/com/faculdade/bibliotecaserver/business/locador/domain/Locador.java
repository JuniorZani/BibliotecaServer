package com.faculdade.bibliotecaserver.business.locador.domain;

import com.faculdade.bibliotecaserver.business.usuario.domain.Usuario;
import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class Locador extends Usuario {

    private String nome;

}
