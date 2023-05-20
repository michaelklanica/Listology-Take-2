package com.example.listology.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LandingPageController {

    @GetMapping("/")
    public String showLandingPage() {
        return "index";
    }

    @GetMapping("/register")
    public String redirectToRegister() {
        return "redirect:/users/register";
    }

    @GetMapping("/login")
    public String redirectToLogin() {
        return "redirect:/users/login";
    }
}

