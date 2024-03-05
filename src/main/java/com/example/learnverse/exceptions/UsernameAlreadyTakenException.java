package com.example.learnverse.exceptions;

import org.springframework.http.HttpStatus;

public class UsernameAlreadyTakenException extends RuntimeException{
    private HttpStatus httpStatus;
    public UsernameAlreadyTakenException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
