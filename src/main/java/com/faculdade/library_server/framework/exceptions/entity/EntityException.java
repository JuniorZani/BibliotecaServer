package com.faculdade.library_server.framework.exceptions.entity;

public abstract class EntityException extends RuntimeException {

    public EntityException(String message) {
        super(message);
    }

    public EntityException(String message, Throwable cause) {
        super(message, cause);
    }

}
