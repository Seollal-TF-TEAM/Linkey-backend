package com.linkey.core.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "users")
public class GitUser {
    @Id
    private long githubUserId;

    @Column(nullable = false, length = 255)
    private String githubUserName;

    @Column(nullable = false)
    private String githubProfileUrl;

    @Column(nullable = true, length = 255)
    private String githubUserEmail;

    @Column(nullable = false, length = 255)
    private String githubReposUrl;

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime githubUpdatedAt;  // GitHub API 업데이트 날짜

    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime updatedAt;  // 사용자 수정 날짜

    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;  // 가입 날짜

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TeamMember> projects = new ArrayList<>();

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

}
