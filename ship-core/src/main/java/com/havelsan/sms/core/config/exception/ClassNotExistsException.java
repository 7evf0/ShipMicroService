package com.havelsan.sms.core.config.exception;

public class ClassNotExistsException extends RuntimeException{
    public ClassNotExistsException(String message){
        super("Class Not Exists: " + message);
    }
}
