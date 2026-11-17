package org.example.bankapi.exception;

public class InsufficentBalanceException extends RuntimeException {
    public InsufficentBalanceException(String message) {
        super(message);
    }
}
