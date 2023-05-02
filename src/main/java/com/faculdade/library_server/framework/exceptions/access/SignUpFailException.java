package com.faculdade.library_server.framework.exceptions.access;

public class SignUpFailException extends AccessException{
    public SignUpFailException(String message) {
        super(message);
    }

    public SignUpFailException(String message, Throwable cause) {
        super(message, cause);
    }
}
