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
    private String password;
    private String username;

    public void setUsername(String username) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setPassword(String password) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
