package com.demo.book_backend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.demo.book_backend.model.ReadingProgress;

public interface ReadingProgressRepository extends MongoRepository<ReadingProgress, String> {
}
