package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "https://linkey.co.kr")
@RestController
@RequestMapping("/api")
public class HelloController {
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello from Spring Boot!\n자동 배포 테스트 - backend\n자동 배포 테스트 - prune";
    }

    @GetMapping("")
    public String apiRoot() {
        return "Welcome to the API root!";
    }
}