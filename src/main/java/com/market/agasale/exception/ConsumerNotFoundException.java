package com.market.agasale.exception;

public class ConsumerNotFoundException extends RuntimeException {
    public ConsumerNotFoundException(String message) {
        super(message);
    }
}
