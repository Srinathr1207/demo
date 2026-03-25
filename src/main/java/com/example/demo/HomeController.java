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

        String secretUser = System.getenv("APP_USERNAME");
        String secretPass = System.getenv("APP_PASSWORD");

        if (secretUser != null && secretUser.equals(username) &&
                secretPass != null && secretPass.equals(password)) {
            model.addAttribute("user", username);
            return "welcome";
        } else {
            model.addAttribute("error", "Invalid username or password!");
            return "index"; // Stay on login page and show error
        }
    }
}