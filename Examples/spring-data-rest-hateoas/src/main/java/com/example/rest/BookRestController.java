package com.example.rest;

import com.example.entities.Book;
import com.example.exceptions.BookNotFoundException;
import com.example.interfaces.BookService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookRestController {
    private final List<Book> books = new ArrayList<>();
    private final BookService bookService;

    @Autowired
    public BookRestController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostConstruct
    public void loadData() {
        this.books.addAll(
                List.of(new Book(1, "BibleX", 10f),
                        new Book(2, "The Imitation of Christ", 10f),
                        new Book(3, "The Fourth Dimension", 10f)
                ));
    }

    @GetMapping("/")
    public List<Book> getAll() {
        return this.bookService.getAll();
    }

    @GetMapping("/{id}")
    public Book getById(@PathVariable int id) {
        Book book = this.bookService.getById(id);

        if (book == null)
            throw new BookNotFoundException("Book not found with id: " + id);

        return book;
    }

    @PostMapping("/")
    public Book save(@RequestBody Book book) {
        return this.bookService.save(book);
    }

    @PutMapping("/")
    public Book update(@RequestBody Book book) {
        return this.bookService.save(book);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) {
        Book book = this.bookService.getById(id);

        if (book == null)
            throw new BookNotFoundException("Book not found with id: " + id);

        this.bookService.deleteById(id);
    }
}