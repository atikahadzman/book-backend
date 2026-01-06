package com.demo.book_backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.demo.book_backend.model.ReadingProgress;
import com.demo.book_backend.repository.ReadingProgressRepository;

@Service
public class ReadingProgressService {
    private final ReadingProgressRepository repository;

    public ReadingProgressService(ReadingProgressRepository repository) {
        this.repository = repository;
    }

    public ReadingProgress create(ReadingProgress readingProgress) {
        return repository.save(readingProgress);
    }

    public List<ReadingProgress> getAll() {
        return repository.findAll();
    }

    public Optional<ReadingProgress> getById(String id) {
        return repository.findById(id);
    }

    public ReadingProgress update(String id, ReadingProgress readingProgress) {
        readingProgress.setId(id);
        return repository.save(readingProgress);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }
}
