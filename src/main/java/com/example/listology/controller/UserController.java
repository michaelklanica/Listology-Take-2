package com.example.listology.controller;

import com.example.listology.dto.UserDTO;
import com.example.listology.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// Import necessary libraries and annotations

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserDTO userDTO) {
        // Validate user input (e.g., username uniqueness, password requirements, etc.)

        // Create a new user based on the userDTO
        UserDTO newUser = new UserDTO();
        newUser.setUsername(userDTO.getUsername());
        newUser.setEmail(userDTO.getEmail());
        newUser.setPassword(userDTO.getPassword());

        // Save the new user to the database using the userService
        userService.registerUser(newUser);

        // Return a success message
        return ResponseEntity.ok("User registered successfully");
    }
}
