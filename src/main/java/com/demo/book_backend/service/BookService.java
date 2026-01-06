package com.demo.book_backend.service;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import com.demo.book_backend.model.Book;
import com.demo.book_backend.repository.BookRepository;

@Service
public class BookService {
    private final BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public Book create(Book book) {
        return repository.save(book);
    }

    public List<Book> getAll() {
        return repository.findAll();
    }

    public Optional<Book> getById(String id) {
        return repository.findById(id);
    }

    public Book update(String id, Book book) {
        book.setId(id);
        return repository.save(book);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }
}
