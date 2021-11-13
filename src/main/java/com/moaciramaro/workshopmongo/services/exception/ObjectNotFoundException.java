package com.moaciramaro.workshopmongo.services.exception;

public class ObjectNotFoundException extends RuntimeException{
     private static final long serialVersionUID;

    static {
        serialVersionUID = 1L;
    }

    public ObjectNotFoundException(String msg) {
         super(msg);
     }
}
