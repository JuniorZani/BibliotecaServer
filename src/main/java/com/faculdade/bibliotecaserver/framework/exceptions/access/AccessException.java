package com.faculdade.bibliotecaserver.framework.exceptions.access;

public abstract class AccessException extends RuntimeException {

    public AccessException(String message) {
        super(message);
    }

    public AccessException(String message, Throwable cause) {
        super(message, cause);
    }

}
