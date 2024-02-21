package com.arcane.pfa.core.exception;

public class UserDetailsException extends RuntimeException{

    public UserDetailsException(){
        super();
    }
    public UserDetailsException(String message){
        super("UserDetailsException - " + message);
    }

}
