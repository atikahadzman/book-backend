package com.demo.book_backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.demo.book_backend.model.Users;
import com.demo.book_backend.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public Users create(Users users) {
        return repository.save(users);
    }

    public List<Users> getAll() {
        return repository.findAll();
    }

    public Optional<Users> getById(String id) {
        return repository.findById(id);
    }

    public Users update(String id, Users users) {
        users.setId(id);
        return repository.save(users);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }
}
