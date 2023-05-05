package com.faculdade.library_server.framework.exceptions.entity;

public class EntityNotSendException extends EntityException{
    public EntityNotSendException(String message) {
        super(message);
    }

    public EntityNotSendException(String message, Throwable cause) {
        super(message, cause);
    }
}
