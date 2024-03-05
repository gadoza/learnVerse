package com.example.learnverse.exceptions;

import org.springframework.http.HttpStatus;

public class BusinessException extends RuntimeException{
    private HttpStatus httpStatus;
    public BusinessException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
