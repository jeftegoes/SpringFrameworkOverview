package com.example.controllers.handlers;

import com.example.response.Response;
import com.example.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BookExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<Response<?>> handleException(NotFoundException ex) {
        Response<?> response = new Response<>(HttpStatus.NOT_FOUND.value(), ex.getMessage(), null);

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
