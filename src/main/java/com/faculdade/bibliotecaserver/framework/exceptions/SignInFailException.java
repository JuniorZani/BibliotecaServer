package com.faculdade.bibliotecaserver.framework.exceptions;

public class SignInFailException extends AccessException {

    public SignInFailException(String message) {
        super(message);
    }

    public SignInFailException(String message, Throwable cause) {
        super(message, cause);
    }
}
