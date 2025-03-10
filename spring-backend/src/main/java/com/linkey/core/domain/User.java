package com.linkey.core.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    private Long githubUserId;

    @Column(nullable = false, length = 255)
    private String githubUserName;

    @Column(nullable = false, unique = true, length = 255)
    private String githubUserEmail;

    @Column(length = 255)
    private String githubReposUrl;

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime githubUpdatedAt;  // GitHub API 업데이트 날짜

    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private LocalDateTime updatedAt;  // 사용자 수정 날짜

    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;  // 가입 날짜
}
