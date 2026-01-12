package com.demo.book_backend.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.demo.book_backend.model.Book;
import com.demo.book_backend.repository.BookRepository;

@Service
public class BookService {
    private final BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

   public Book create(Book book, MultipartFile file) {
        if (book.getStatus() == null || book.getStatus().isBlank()) {
            book.setStatus("AVAILABLE");
        }

        if (file != null && !file.isEmpty()) {
            String contentType = file.getContentType();
            if (contentType == null || !contentType.startsWith("image/")) {
                throw new IllegalArgumentException("Only image files are allowed");
            }

            try {
                String filename = UUID.randomUUID() + "_" + file.getOriginalFilename();
                Path uploadDir = Paths.get(System.getProperty("user.dir"), "uploads");
                Path path = uploadDir.resolve(filename);

                Files.createDirectories(uploadDir);
                Files.write(path, file.getBytes());

                book.setCoverImage(path.toString());

            } catch (IOException e) {
                throw new RuntimeException("Image upload failed", e);
            }
        }

        // book.setCreatedAt(Instant.now());
        book.setCreatedAt(Instant.now().toString());

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
