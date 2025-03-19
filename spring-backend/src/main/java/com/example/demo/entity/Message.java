package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Message {
    @Id
    private Long id;
    private String content;

    // 기본 생성자 (JPA 요구사항)
    public Message() {}

    public Message(Long id, String content) {
        this.id = id;
        this.content = content;
    }

    // Getter와 Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}