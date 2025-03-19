package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "https://linkey.co.kr")
@RestController
@RequestMapping("/api")
public class HealthController {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/db-check")
    public String checkDatabaseConnection() {
        try {
            jdbcTemplate.execute("SELECT 1");
            return "Database connection successful!";
        } catch (Exception e) {
            return "Database connection failed: " + e.getMessage();
        }
    }
}