package com.linkey.core.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class UserController {
    @GetMapping("/session")
    public ResponseEntity<?> getSessionData(HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");
        String accessToken = (String) session.getAttribute("accessToken");

        if (userId == null || accessToken == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Session expired or not logged in.");
        }

        Map<String, Object> response = new HashMap<>();
        response.put("userId", userId);
        response.put("accessToken", accessToken);

        System.out.println("userId = " + userId);
        System.out.println("accessToken = " + accessToken);

        System.out.println("response = " + response);

        return ResponseEntity.ok(response);
    }
}
