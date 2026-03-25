package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    // Shows the login page
    @GetMapping("/")
    public String showLogin() {
        return "index";
    }

    // Handles the form submission
    @PostMapping("/login")
    public String handleLogin(
            @RequestParam String username,
            @RequestParam String password,
            Model model) {

        // HARDCODED VALUES
        if ("Demo".equals(username) && "Srinath@90".equals(password)) {
            model.addAttribute("user", username);
            return "welcome"; // We will create this next
        } else {
            model.addAttribute("error", "Invalid username or password!");
            return "index"; // Stay on login page and show error
        }
    }
}