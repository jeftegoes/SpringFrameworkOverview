package com.example.services;

import com.example.entities.Book;
import com.example.exceptions.BookNotFoundException;
import com.example.interfaces.BookRepository;
import com.example.interfaces.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getAll() {
        return this.bookRepository.findAll();
    }

    @Override
    public Book getById(int id) {
        return this.bookRepository.findById(id).orElse(null);
    }

    @Override
    public Book save(Book book) {
        return this.bookRepository.save(book);
    }

    @Override
    public void deleteById(int id) {
        this.bookRepository.deleteById(id);
    }
}
