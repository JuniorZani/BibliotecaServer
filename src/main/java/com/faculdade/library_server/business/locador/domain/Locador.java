package com.faculdade.library_server.business.locador.domain;

import com.faculdade.library_server.business.usuario.domain.Usuario;
import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class Locador extends Usuario {

    private String nome;

}
