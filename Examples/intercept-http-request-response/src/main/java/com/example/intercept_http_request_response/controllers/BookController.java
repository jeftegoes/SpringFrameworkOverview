package com.example.intercept_http_request_response.controllers;

import com.example.intercept_http_request_response.entities.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
    @GetMapping("/")
    public Book getBook() {
        return new Book(1, "Bible", 49.90f);
    }

    @PostMapping("/")
    public Book postBook() {
        var a = 10;
        var b = 0;
        var c = a / b;
        return new Book(1, "Bible", 49.90f);
    }
}
