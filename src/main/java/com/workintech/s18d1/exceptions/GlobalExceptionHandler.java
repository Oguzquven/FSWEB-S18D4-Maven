package com.workintech.s18d1.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BurgerException.class)
    public ResponseEntity<BurgerErrorResponse> handleBurgerException(BurgerException e) {
        return new ResponseEntity<>(
                new BurgerErrorResponse(e.getMessage()),
                e.getHttpStatus()
        );
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<BurgerErrorResponse> handleGeneralException(Exception e) {
        return new ResponseEntity<>(
                new BurgerErrorResponse(e.getMessage()),
                org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR
        );
    }
}