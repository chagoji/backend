package com.example.demo.exception;

public class UserAuthenticationException extends RuntimeException{
    public UserAuthenticationException(String message){
        super(message);
    }
}
