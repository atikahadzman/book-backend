package com.demo.book_backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "books")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    private String id;
    private String title;
    private String status;
    private String author;
    private String description;
    private String coverImage;
    private Integer totalPages;
    private String createdAt;
    private String bookUrl;
}
