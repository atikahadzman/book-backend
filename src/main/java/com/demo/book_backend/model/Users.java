package com.demo.book_backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "users")
@Data
public class Users 
{
    @Id
    private String id;
    private String name;
    private String role;
    private String email;
    private String phone;
    private String status;
    private String book_id;
    private long created_at;
}
