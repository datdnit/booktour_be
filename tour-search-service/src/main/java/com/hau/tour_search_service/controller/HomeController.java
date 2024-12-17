package com.hau.tour_search_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "Welcome to the Tour Search Service API! Access /api/tours for more.";
    }

    @GetMapping("/api")
    public String apiHome() {
        return "This is the API root. Access /api/tours for tour management endpoints.";
    }
}
