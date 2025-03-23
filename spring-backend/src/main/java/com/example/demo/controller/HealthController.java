package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "https://linkey.co.kr")
@RestController
@RequestMapping("/api")
public class HealthController {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @GetMapping("/db-check")
    public String checkDatabaseConnection() {
        StringBuilder result = new StringBuilder();

        // PostgreSQL 연결 테스트
        try {
            jdbcTemplate.execute("SELECT 1");
            result.append("Postgresql connection successful!\n");
        } catch (Exception e) {
            result.append("Postgresql connection failed: ").append(e.getMessage()).append                .append("\n");
        }

        // Redis 연결 테스트
        try {
            stringRedisTemplate.opsForValue().set("health-check", "ok");
            String value = stringRedisTemplate.opsForValue().get("health-check");
            if ("ok".equals(value)) {
                result.append("Redis connection successful!");
            } else {
                result.append("Redis connection failed: Unexpected value returned");
            }
        } catch (Exception e) {
            result.append("Redis connection failed: ").append(e.getMessage());
        }

        return result.toString();
    }
}