package com.contaazul.mars.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CAMarsDefaultExceptionHandler {


    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleRuntimeException(RuntimeException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(HttpStatus.BAD_REQUEST.toString() + " " + HttpStatus.BAD_REQUEST.getReasonPhrase());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleRuntimeException( Exception e){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(HttpStatus.BAD_REQUEST.toString() + " " + HttpStatus.BAD_REQUEST.getReasonPhrase());
    }

}
