package com.example.listology.controller;

import com.example.listology.model.User;
import com.example.listology.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SignupController {

    private final UserService userService;

    @Autowired
    public SignupController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/signup")
    public String showSignupForm(Model model) {
        model.addAttribute("user", new User());
        return "signup";
    }

    @PostMapping("/signup")
    public String processSignup(User user) {
        String result = userService.createUser(user);
        System.out.println(result);
        // Handle the result and perform necessary actions (e.g., redirect, display error message)
        if (result.equals("User created successfully")) {
            // User creation was successful, redirect to a success page
            return "redirect:/main";
        } else {
            // User creation failed, display error message on the signup form
            return "signup";
        }
    }
}
