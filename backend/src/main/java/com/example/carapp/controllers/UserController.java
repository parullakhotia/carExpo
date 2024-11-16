package com.example.carapp.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.carapp.entities.User;
import com.example.carapp.services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Register a new user
    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        try {
            return ResponseEntity.ok(userService.registerUser(user));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    // Login user
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody User loginRequest) {
        Optional<User> user = userService.getUserByUsername(loginRequest.getUsername());
        if (user.isPresent() && user.get().getPassword().equals(loginRequest.getPassword())) {
            // Note: This is for demonstration only.
            // In production, avoid returning the password and consider generating a token.
            return ResponseEntity.ok(user.get());
        } else {
            return ResponseEntity.status(401).body("Invalid username or password");
        }
    }

    // Add a new user (admin use case)
    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody User user) {
        try {
            return ResponseEntity.ok(userService.registerUser(user));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    // Delete a user by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Integer id) {
        Optional<User> user = userService.getUserById(id);
        if (user.isPresent()) {
            userService.deleteUser(id);
            return ResponseEntity.ok("User deleted successfully");
        } else {
            return ResponseEntity.badRequest().body("User not found");
        }
    }

    // Get a user by ID
    @GetMapping("/{id}")
    public ResponseEntity<Optional<User>> getUserById(@PathVariable Integer id) {
        Optional<User> user = userService.getUserById(id);
        if (user.isPresent()) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.badRequest().body(Optional.empty());
        }
    }

    // Get all users (admin use case)
    @GetMapping
    public ResponseEntity<?> getAllUsers() {
        try {
            return ResponseEntity.ok(userService.getAllUsers());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Failed to fetch users");
        }
    }
}
