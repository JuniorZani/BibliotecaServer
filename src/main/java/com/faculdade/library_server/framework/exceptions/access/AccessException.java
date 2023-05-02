package com.faculdade.library_server.framework.exceptions.access;

public abstract class AccessException extends RuntimeException {

    public AccessException(String message) {
        super(message);
    }

    public AccessException(String message, Throwable cause) {
        super(message, cause);
    }

}
