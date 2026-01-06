package com.demo.book_backend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.demo.book_backend.model.Users;

public interface UserRepository extends MongoRepository<Users, String> {
}
