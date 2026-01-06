package com.demo.book_backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.book_backend.model.ReadingProgress;
import com.demo.book_backend.service.ReadingProgressService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/readingprogress")

public class ReadingProgressController {
    private final ReadingProgressService service;

    public ReadingProgressController(ReadingProgressService service) {
        this.service = service;
    }

    // CREATE
    @PostMapping
    public ReadingProgress create(@RequestBody ReadingProgress progress) {
        return service.create(progress);
    }

    // READ ALL
    @GetMapping
    public List<ReadingProgress> getAll() {
        return service.getAll();
    }

    // READ BY ID
    @GetMapping("/{id}")
    public ReadingProgress getById(@PathVariable String id) {
        return service.getById(id)
            .orElseThrow(() -> new RuntimeException("Not found"));
    }

    // UPDATE
    @PutMapping("/{id}")
    public ReadingProgress update(@PathVariable String id, @RequestBody ReadingProgress progress) {
        return service.update(id, progress);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String delete(@PathVariable String id) {
        service.delete(id);
        return "Progress deleted successfully";
    }
}
