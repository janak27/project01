package com.example.project01.controller; // Defines the package where this class belongs

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * HomeController is a simple controller that handles the root ("/") endpoint.
 * It provides a welcome message when the user accesses the application.
 */
@RestController // Marks this class as a RESTful controller, meaning it will handle HTTP requests
@RequestMapping("/") // Maps all incoming requests with "/" to this controller
public class HomeController {

    /**
     * Handles GET requests to the root URL ("/").
     * When a user visits "http://localhost:8080/", they receive a welcome message.
     * 
     * @return A simple welcome message as a String.
     */
    @GetMapping // Maps HTTP GET requests to this method
    public String home() {
        return "Welcome to the Note-Taking App!"; // Returns a plain text response
    }
}
