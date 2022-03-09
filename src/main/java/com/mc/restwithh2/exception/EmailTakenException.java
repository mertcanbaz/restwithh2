package com.mc.restwithh2.exception;

public class EmailTakenException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public EmailTakenException(String msg) {
        super(msg);
    }
}
