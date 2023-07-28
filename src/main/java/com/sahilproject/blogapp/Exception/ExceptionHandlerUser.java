package com.sahilproject.blogapp.Exception;


import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.TransactionSystemException;

import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.bind.annotation.RestControllerAdvice;



@RestControllerAdvice
public class ExceptionHandlerUser {
    
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<userError> handler(ResourceNotFoundException r){
        userError user=new userError(HttpStatus.NOT_FOUND.value() , r.getMessage());
        return new ResponseEntity<>(user,HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler(TransactionSystemException.class)
    public ResponseEntity<userError> handler(TransactionSystemException ts){
            userError u=new userError(HttpStatus.PARTIAL_CONTENT.value(), ts.getLocalizedMessage());
            return new ResponseEntity<userError>(u, HttpStatus.PARTIAL_CONTENT);
    }
}
