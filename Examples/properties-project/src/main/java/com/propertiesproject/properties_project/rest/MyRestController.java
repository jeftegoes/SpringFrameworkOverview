package com.propertiesproject.properties_project.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestController {
    @Value("${books.name}")
    private String book;

    @Value("${authors.name}")
    private String author;

    @GetMapping("/")
    public String GetBook() {
        return "Book: " + book + " By " + author;
    }
}
