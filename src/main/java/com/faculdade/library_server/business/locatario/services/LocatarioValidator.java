package com.faculdade.library_server.business.locatario.services;

import com.faculdade.library_server.business.locatario.domain.Locatario;
import com.faculdade.library_server.business.locatario.repositories.LocatarioValidatorRepository;
import com.faculdade.library_server.framework.entities.service.GenericValidator;
import org.springframework.stereotype.Service;

@Service
public class LocatarioValidator extends GenericValidator<Locatario, LocatarioValidatorRepository> {
}
