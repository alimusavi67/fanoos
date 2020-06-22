package com.fanoos.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "ridi")
public class BankExistException extends RuntimeException{
    public BankExistException() {
        super();
    }
    public BankExistException(String message) {
        super(message);
    }
    public BankExistException(String message, Throwable cause) {
        super(message, cause);
    }
}
