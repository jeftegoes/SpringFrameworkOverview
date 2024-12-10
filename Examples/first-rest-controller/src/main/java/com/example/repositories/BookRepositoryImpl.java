package com.example.repositories;

import com.example.entities.Book;
import com.example.interfaces.BookRepository;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class BookRepositoryImpl implements BookRepository {
    private final EntityManager entityManager;

    @Autowired
    public BookRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Book> getAll() {
        return this.entityManager.createQuery("FROM Book", Book.class).getResultList();
    }

    @Override
    public Book getById(int id) {
        return this.entityManager.find(Book.class, id);
    }

    @Transactional
    @Override
    public Book save(Book book) {
        return this.entityManager.merge(book);
    }

    @Transactional
    @Override
    public void deleteById(int id) {
        Book book = this.entityManager.find(Book.class, id);

        this.entityManager.remove(book);
    }
}
