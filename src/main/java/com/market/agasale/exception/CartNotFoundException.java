package com.market.agasale.exception;

public class CartNotFoundException extends RuntimeException{
    public CartNotFoundException(String message) {
        super(message);
    }
}
