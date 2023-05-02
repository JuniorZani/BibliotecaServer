package com.faculdade.library_server.framework.exceptions.entity;

public class EntityNotFoundException extends EntityException{
    public EntityNotFoundException(String message) {
        super(message);
    }

    public EntityNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
