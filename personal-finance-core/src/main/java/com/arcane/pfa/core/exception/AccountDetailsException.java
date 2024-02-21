package com.arcane.pfa.core.exception;

public class AccountDetailsException extends RuntimeException{

    public AccountDetailsException(){
        super();
    }

    public AccountDetailsException(String message){
        super(message);
    }
}
