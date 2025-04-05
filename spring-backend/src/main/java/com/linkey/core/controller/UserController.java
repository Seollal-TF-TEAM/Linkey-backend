package com.linkey.core.controller;

import com.linkey.core.repository.user.GitUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final RedisTemplate<String, String> redisTemplate;
    private final GitUserRepository gitUserRepository;

    // user 정보 가져오기 (nav bar)
    @GetMapping("")
    public ResponseEntity<?> getUser(@RequestParam Long githubUserId) {
        return gitUserRepository.findByGithubUserId(githubUserId)
                .map(user -> {
                    Map<String, Object> response = new HashMap<>();
                    response.put("githubUserName", user.getGithubUserName());
                    response.put("githubProfileUrl", user.getGithubProfileUrl());
                    return ResponseEntity.ok(response);
                })
                .orElse(ResponseEntity.ok(null)); // orElseThrow 말고 null 리턴
    }

    // userId로 accessToken 직접 조회 (예: 테스트용)
    @GetMapping("/token")
    public ResponseEntity<?> getAccessToken(@RequestParam Long userId) {
        String token = redisTemplate.opsForValue().get("github:token:" + userId);
        if (token == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Token not found");
        }
        return ResponseEntity.ok(Map.of("accessToken", token));
    }
}
