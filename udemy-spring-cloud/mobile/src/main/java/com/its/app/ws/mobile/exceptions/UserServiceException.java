package com.its.app.ws.mobile.exceptions;

public class UserServiceException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = -8636103175926138220L;

    public UserServiceException(String messaeg) {
        super(messaeg);
    }
}
