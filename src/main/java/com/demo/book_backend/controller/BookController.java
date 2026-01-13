package com.demo.book_backend.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.demo.book_backend.model.Book;
import com.demo.book_backend.repository.BookRepository;
import com.demo.book_backend.service.BookService;
import com.demo.book_backend.service.FileStorageService;

@RestController
@RequestMapping("/api/books")
@CrossOrigin(origins = "http://localhost:4200")

public class BookController {
    private final BookService service;
    private final BookRepository bookRepository;
    private final FileStorageService fileStorageService;

    public BookController(
        BookService service,
        BookRepository bookRepository,
        FileStorageService fileStorageService
    ) {
        this.service = service;
        this.bookRepository = bookRepository;
        this.fileStorageService = fileStorageService;
    }
    
    @PostMapping(consumes = "multipart/form-data")
    public Book createBook(
            @RequestParam String title,
            @RequestParam String author,
            @RequestParam String description,
            @RequestParam MultipartFile coverImage,
            @RequestParam MultipartFile bookFile
    ) throws Exception {
        Book book = new Book();
        book.setTitle(title);
        book.setAuthor(author);
        book.setDescription(description);

        book.setCoverImage(fileStorageService.saveFile(coverImage, "images"));
        book.setBookUrl(fileStorageService.saveFile(bookFile, "pdfs"));

        return bookRepository.save(book);
    }

    // READ ALL
    @GetMapping
    public List<Book> getAll() {
        return service.getAll();
    }

    // READ BY ID
    @GetMapping("/{id}")
    public Book getById(@PathVariable String id) {
        return service.getById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));
    }

    // UPDATE
    @PutMapping("/{id}")
    public Book update(@PathVariable String id, @RequestBody Book book) {
        return service.update(id, book);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public Map<String, String> delete(@PathVariable String id) {
        service.delete(id);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Book deleted successfully");
        return response;
    }
}
