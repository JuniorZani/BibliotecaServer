package com.faculdade.bibliotecaserver.framework.exceptions;

public abstract class EntityException extends RuntimeException {

    public EntityException(String message) {
        super(message);
    }

    public EntityException(String message, Throwable cause) {
        super(message, cause);
    }

}
