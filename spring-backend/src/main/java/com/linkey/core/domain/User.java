package com.linkey.core.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    private long githubUserId;

    @Column(nullable = false, length = 255)
    private String githubUserName;

    @Column(nullable = false, length = 255)
    private String githubUserEmail;

    @Column(nullable = false, length = 255)
    private String githubReposUrl;

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime githubUpdatedAt;  // GitHub API 업데이트 날짜

    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private LocalDateTime updatedAt;  // 사용자 수정 날짜

    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;  // 가입 날짜

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TeamMember> projects = new ArrayList<>();
}
