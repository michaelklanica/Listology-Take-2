package com.example.listology.service;

import com.example.listology.model.User;
import com.example.listology.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String createUser(User user) {
        String username = user.getUsername();
        String email = user.getEmail();

        // Check if a user with the same username or email already exists
        if (userRepository.existsByUsername(username)) {
            return "Username already exists";
        }

        if (userRepository.existsByEmail(email)) {
            return "Email address already exists";
        }

        // Save the user to the database
        userRepository.save(user);

        return "User created successfully";
    }
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    public User getUserById(Long userId) {
        // Implementation to fetch user by ID from the database
        // Replace this with your actual implementation
        return userRepository.findById(userId).orElse(null);
    }
}