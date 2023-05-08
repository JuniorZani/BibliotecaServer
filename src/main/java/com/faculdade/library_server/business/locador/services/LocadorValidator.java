package com.faculdade.library_server.business.locador.services;

import com.faculdade.library_server.business.locador.domain.Locador;
import com.faculdade.library_server.business.locador.repositories.LocadorValidatorRepository;
import com.faculdade.library_server.framework.entities.service.GenericValidator;
import org.springframework.stereotype.Service;

@Service
public class LocadorValidator extends GenericValidator<Locador, LocadorValidatorRepository> {
}
