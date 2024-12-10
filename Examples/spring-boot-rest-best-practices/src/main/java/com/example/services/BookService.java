package com.example.services;

import com.example.requests.BookRequest;
import com.example.response.BookResponse;
import com.example.exceptions.NotFoundException;
import com.example.models.Book;
import com.example.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<BookResponse> findAll() {
        List<Book> books = this.bookRepository.findAll();

        return books.stream().map(this::BookToBookResponse).collect(Collectors.toList());
    }

    public BookResponse findById(int id) {
        Book book = this.bookRepository.findById(id).orElseThrow(() -> new NotFoundException("Book " + id + " not found!"));

        return BookToBookResponse(book);
    }

    public BookResponse update(BookRequest bookRequest) {
        Book book = new Book(bookRequest.getId(), bookRequest.getName(), bookRequest.getPrice());

        return BookToBookResponse(this.bookRepository.save(book));
    }

    public void delete(int id) {
        Book book = this.bookRepository.findById(id).orElseThrow(() -> new NotFoundException("Book not found!"));

        this.bookRepository.delete(book);
    }

    public BookResponse save(BookRequest bookRequest) {
        Book book = new Book(bookRequest.getName(), bookRequest.getPrice());

        return BookToBookResponse(this.bookRepository.save(book));
    }

    private BookResponse BookToBookResponse(Book book) {
        return new BookResponse(book.getId(), book.getName(), book.getPrice());
    }
}
