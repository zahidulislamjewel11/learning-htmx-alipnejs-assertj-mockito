package com.zahid.htmx.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HtmxController {
    
    @GetMapping("/") 
    public String getHomePage() {
        return "Welcome to Spring Boot Htmx Application";
    }
}
