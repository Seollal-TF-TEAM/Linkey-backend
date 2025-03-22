package com.linkey.core.domain.entity;

import jakarta.persistence.*;
import lombok.*;
import com.linkey.core.domain.dto.GitUserDto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@AllArgsConstructor
@Table(name = "users")
public class GitUser {

    public GitUser(Long githubUserId) {
        this.githubUserId = githubUserId;
    }

    @Id
    private long githubUserId;

    @Column(nullable = false, length = 255)
    private String githubUserName;

    @Column(nullable = false, length = 255)
    private String githubProfileUrl;

    @Column(nullable = true, length = 255)
    private String githubUserEmail;

    @Column(nullable = true, length = 255)
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

    public static GitUser fromDto(GitUserDto dto) {
        return GitUser.builder()
                .githubUserId(dto.getGithubUserId())
                .githubUserName(dto.getGithubUserName())
                .githubProfileUrl(dto.getGithubProfileUrl())
                .githubUserEmail(dto.getGithubUserEmail())
                .githubReposUrl(dto.getGithubReposUrl())
                .githubUpdatedAt(dto.getGithubUpdatedAt())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
    }

}
