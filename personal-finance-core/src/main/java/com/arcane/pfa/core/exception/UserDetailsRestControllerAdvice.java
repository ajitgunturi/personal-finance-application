package com.arcane.pfa.core.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class UserDetailsRestControllerAdvice extends ResponseEntityExceptionHandler {
    @ExceptionHandler(UserDetailsException.class)
    public ResponseEntity<String> handleCheckUserException(Exception ex, WebRequest request){
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}
