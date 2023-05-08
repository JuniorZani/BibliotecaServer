package com.faculdade.library_server.business.emprestimo.services;

import com.faculdade.library_server.business.emprestimo.domain.Emprestimo;
import com.faculdade.library_server.business.emprestimo.repositories.EmprestimoRepository;
import com.faculdade.library_server.business.emprestimo.repositories.EmprestimoValidatorRepository;
import com.faculdade.library_server.business.item.domain.Item;
import com.faculdade.library_server.business.item.domain.ItemStatus;
import com.faculdade.library_server.business.item.services.ItemService;
import com.faculdade.library_server.business.locatario.domain.Locatario;
import com.faculdade.library_server.business.locatario.services.LocatarioService;
import com.faculdade.library_server.framework.entities.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class EmprestimoService extends GenericService<Emprestimo, EmprestimoRepository, EmprestimoValidatorRepository, EmprestimoValidator> {

    @Autowired private ItemService itemService;

    @Autowired private LocatarioService locatarioService;

    public Emprestimo emprestar(UUID itemId, UUID locatarioId){
        getValidator().emprestar(itemId, locatarioId);

        Item item = itemService.read(itemId);
        Integer quantidadeAtual = item.getQuantidade();
        item.setStatus(ItemStatus.ALUGADO);
        item.setQuantidade(quantidadeAtual - 1);

        item = itemService.emprestar(itemId);

        Locatario locatario = locatarioService.read(locatarioId);

        Emprestimo emprestimo = Emprestimo.builder()
                .item(item)
                .locatario(locatario)
                .build();

        return super.create(emprestimo);
    }

}
