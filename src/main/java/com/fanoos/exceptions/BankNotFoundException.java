package com.fanoos.exceptions;

public class BankNotFoundException extends RuntimeException{
    public BankNotFoundException() {

    }

    public BankNotFoundException(Long bankId) {
        super("Bank: " + bankId + " not found");
    }
}
