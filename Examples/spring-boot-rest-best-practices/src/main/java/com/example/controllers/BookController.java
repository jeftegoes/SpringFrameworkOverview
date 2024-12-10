package com.example.controllers;

import com.example.requests.BookRequest;
import com.example.response.BookResponse;
import com.example.response.Response;
import com.example.services.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/")
    public Response<?> findAll() {
        return new Response<>(
                HttpStatus.OK.value(),
                "Books returned successfully!",
                this.bookService.findAll());
    }

    @GetMapping("/{id}")
    public Response<?> findById(@PathVariable int id) {
        return new Response<>(
                HttpStatus.OK.value(),
                "Book returned successfully!",
                this.bookService.findById(id));
    }

    @PutMapping("/")
    public Response<?> update(@RequestBody BookRequest bookRequest) {
        return new Response<>(
                HttpStatus.OK.value(),
                "Book updated successfully!",
                this.bookService.update(bookRequest));
    }

    @DeleteMapping("/{id}")
    public Response delete(@PathVariable int id) {
        this.bookService.delete(id);
        return new Response<>(
                HttpStatus.OK.value(),
                "Book deleted successfully!",
                null);
    }

    @PostMapping("/")
    public ResponseEntity<?> save(@RequestBody BookRequest bookRequest) {
        Response<BookResponse> response = new Response<>(
                HttpStatus.CREATED.value(),
                "Book saved successfully!",
                this.bookService.save(bookRequest));

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
