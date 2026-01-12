package com.demo.book_backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

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
    private String category;
    private String description;

    @Field("cover_image")
    private String coverImage;

    @Field("total_pages")
    private Integer totalPages;

    @Field("created_at")
    private String createdAt;

    @Field("book_url")
    private String bookUrl;
}
