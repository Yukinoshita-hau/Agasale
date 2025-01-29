package com.market.agasale.exception_handler;

import com.market.agasale.common.JsonErrorResponse;
import com.market.agasale.exception.ConsumerNotFoundException;
import com.market.agasale.exception.SellerNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ConsumerNotFoundException.class)
    public ResponseEntity<JsonErrorResponse> handlerConsumerNotFound(ConsumerNotFoundException e) {
        JsonErrorResponse errorResponse = new JsonErrorResponse(e.getMessage(), HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(SellerNotFoundException.class)
    public ResponseEntity<JsonErrorResponse> handlerSellerNotFound(SellerNotFoundException e) {
        JsonErrorResponse errorResponse = new JsonErrorResponse(e.getMessage(), HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}
