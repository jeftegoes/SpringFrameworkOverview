package com.example.handlers;

import com.example.exceptions.BookNotFoundException;
import com.example.responses.BookErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BookRestExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<BookErrorResponse> handleException(BookNotFoundException exc) {
        BookErrorResponse bookErrorResponse = new BookErrorResponse(HttpStatus.NOT_FOUND.value(), exc.getMessage(), System.currentTimeMillis());

        return new ResponseEntity<>(bookErrorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<BookErrorResponse> handleException(Exception exc) {
        BookErrorResponse bookErrorResponse = new BookErrorResponse(HttpStatus.BAD_REQUEST.value(), exc.getMessage(), System.currentTimeMillis());

        return new ResponseEntity<>(bookErrorResponse, HttpStatus.BAD_REQUEST);
    }
}
