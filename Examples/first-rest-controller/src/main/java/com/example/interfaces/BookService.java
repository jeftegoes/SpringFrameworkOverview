package com.example.interfaces;

import com.example.entities.Book;

import java.util.List;

public interface BookService {
    List<Book> getAll();

    Book getById(int id);

    Book save(Book book);

    void deleteById(int id);
}
