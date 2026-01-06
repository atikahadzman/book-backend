package com.demo.book_backend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.demo.book_backend.model.Book;

public interface BookRepository extends MongoRepository<Book, String> {
}
