package com.demo.book_backend.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.demo.book_backend.model.Users;

public interface UserRepository extends MongoRepository<Users, String> {
    Optional<Users> findByUsername(String username);
}
