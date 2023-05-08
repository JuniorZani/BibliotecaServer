package com.faculdade.library_server.business.locador.domain;

import com.faculdade.library_server.business.item.domain.Item;
import com.faculdade.library_server.business.locatario.domain.Locatario;
import com.faculdade.library_server.business.usuario.domain.Usuario;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
public class Locador extends Usuario {

    private String nome;

    @OneToMany(mappedBy = "locador")
    private List<Item> itens;

    @OneToMany(mappedBy = "locador")
    private List<Locatario> locatarios;

}
