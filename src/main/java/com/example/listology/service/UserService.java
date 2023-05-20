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

    public User registerUser(User user) {
        // Perform necessary validations and logic for user registration
        // For example, check if the username or email is already taken

        // Save the user to the database
        return userRepository.save(user);
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    // Other user-related methods
}
