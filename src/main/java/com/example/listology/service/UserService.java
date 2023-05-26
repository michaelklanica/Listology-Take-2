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

    public User createUser(User user) {
        // Perform any necessary validation or checks on the user data

        // Save the user using the UserRepository
        return userRepository.save(user);
    }

    // Other user-related methods
}
