package com.linkey.core.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class UserController {

    private final RedisTemplate<String, String> redisTemplate;

    @GetMapping("/token")
    public ResponseEntity<?> getAccessToken(@RequestParam Long userId) {
        String token = redisTemplate.opsForValue().get("github:token:" + userId);
        if (token == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Token not found");
        }
        return ResponseEntity.ok(Map.of("accessToken", token));
    }
}
