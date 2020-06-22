package com.fanoos.exceptions;

import lombok.extern.slf4j.XSlf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
//@XSlf4j
public class RestExceptionHandler {
    @ExceptionHandler(value = {BankNotFoundException.class})
    public ResponseEntity banksEntityNotFound(BankNotFoundException ex, WebRequest request) {
//        log.debug("handling BankNotFoundException...");
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}
