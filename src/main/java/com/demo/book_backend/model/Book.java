package com.demo.book_backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "books")
@Data
public class Book {
    @Id
    private String id;
    private String title;
    private String status;
    private String author;
    private String category;
    private String description;
    private String cover_image;
    private Integer total_pages;
    private String created_at;
    private String book_url;
}
