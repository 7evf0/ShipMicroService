package com.havelsan.sms.core.config.exception;

public class ClassExistsException extends RuntimeException{
    public ClassExistsException(String message){
        super("Class already exists: " + message);
    }
}
