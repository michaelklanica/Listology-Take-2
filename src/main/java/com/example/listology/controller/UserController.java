package com.example.listology.controller;

import ch.qos.logback.core.model.Model;
import com.example.listology.model.User;
import com.example.listology.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/{id}")
    public String showUserDetails(@PathVariable Long id, Model model) {
        // Logic to retrieve the user details by ID
        // ...
        // Set the user details in the model
        // model.addAttribute("user", user);
        return "userDetails";
    }

    @GetMapping("/register")
    public String showRegistrationPage() {
        return "register";
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @PostMapping("/register")
    public String registerUser(User user) {
        // Logic to register the user
        // ...

        // Redirect the user to their profile page after successful registration
        return "redirect:/users/" + user.getId();
    }

    // Other user-related methods
}
