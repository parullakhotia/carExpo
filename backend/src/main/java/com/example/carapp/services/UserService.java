package com.example.carapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.carapp.entities.User;
import com.example.carapp.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Create a new user
    public User createUser(User user) {
        // No password encryption
        return userRepository.save(user);
    }

    // Get user by ID
    public Optional<User> getUserById(Integer id) {
        return userRepository.findById(id);
    }

    // Get user by username
    public Optional<User> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    // Update user details
    public User updateUser(Integer id, User updatedUser) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Update only non-null fields
        if (updatedUser.getUsername() != null) {
            existingUser.setUsername(updatedUser.getUsername());
        }
        if (updatedUser.getEmail() != null) {
            existingUser.setEmail(updatedUser.getEmail());
        }
        if (updatedUser.getPassword() != null) {
            // Store password as plain text (temporary)
            existingUser.setPassword(updatedUser.getPassword());
        }

        return userRepository.save(existingUser);
    }

    // Delete a user by ID
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }

    // Get all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User registerUser(User user) {
        // Check if username or email already exists
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            throw new IllegalArgumentException("Username already exists");
        }
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Email already exists");
        }

        // No password encryption
        return userRepository.save(user);
    }
}
