package com.example.listology.controller;

import com.example.listology.model.User;
import com.example.listology.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class LandingController {
    @Autowired
    private UserService userService;
    @GetMapping("/")
    public String showLandingPage() {
        return "landing";
    }

    @GetMapping("/main")
    public String showMainPage() {
        // Logic to retrieve data and prepare the main page
        return "main"; // Return the name of the main page template (e.g., "main.html")
    }

    @PostMapping("/login")
    public String processLogin(User user, HttpSession session, Model model) {
        String username = user.getUsername();
        String password = user.getPassword();

        // Retrieve the user from the database based on the username
        User existingUser = userService.getUserByUsername(username);

        // Check if the user exists and the password is correct
        if (existingUser != null && existingUser.getPassword().equals(password)) {
            // Authentication successful, store the user object in the session
            session.setAttribute("loggedInUser", existingUser);
            return "redirect:/main"; // Redirect to the main page
        } else {
            // Authentication failed, display an error message
            model.addAttribute("error", "Invalid username or password");
            return "landing";
        }
    }

}
