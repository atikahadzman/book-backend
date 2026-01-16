package com.demo.book_backend.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.book_backend.dto.LoginRequest;
import com.demo.book_backend.model.Users;
import com.demo.book_backend.repository.UserRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody LoginRequest request) {
        Map<String, String> response = new HashMap<>();
        return userRepository.findByUsername(request.getUsername())
                .map(user -> {
                    if (user.getPassword().equals(request.getPassword())) {
                        response.put("message", "Login successful!");
                        response.put("id", user.getId());
                        response.put("username", user.getUsername());
                        return ResponseEntity.ok(response);
                    } else {
                        response.put("message", "Invalid password");
                        return ResponseEntity.status(401).body(response);
                    }
                })
                .orElseGet(() -> {
                    response.put("message", "User not found");
                    return ResponseEntity.status(404).body(response);
                });
        }

    @PostMapping("/register")
    public ResponseEntity<Map<String, String>> register(@RequestBody LoginRequest request) {
        Map<String, String> response = new HashMap<>();

        if (userRepository.findByUsername(request.getUsername()).isPresent()) {
            response.put("message", "Username already exists");
            return ResponseEntity.badRequest().body(response);
        }

        Users user = new Users();
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        userRepository.save(user);

        response.put("message", "User registered successfully!");
        return ResponseEntity.ok(response);
    }
}
