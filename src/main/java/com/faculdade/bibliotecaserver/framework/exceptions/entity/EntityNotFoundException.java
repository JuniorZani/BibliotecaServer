package com.faculdade.bibliotecaserver.framework.exceptions.entity;

public class EntityNotFoundException extends EntityException{
    public EntityNotFoundException(String message) {
        super(message);
    }

    public EntityNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
