package com.faculdade.bibliotecaserver.framework.exceptions;

public class SignUpFailException extends AccessException{
    public SignUpFailException(String message) {
        super(message);
    }

    public SignUpFailException(String message, Throwable cause) {
        super(message, cause);
    }
}
