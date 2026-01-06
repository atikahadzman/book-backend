package com.demo.book_backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "readingprogress")
@Data
public class ReadingProgress {
    @Id
    private String id;
    private String user_id;
    private String book_id;
    private String status;
    private int current_page;
    private Long started_at;
    private Long last_read_at;
    private Long completed_at;
}
