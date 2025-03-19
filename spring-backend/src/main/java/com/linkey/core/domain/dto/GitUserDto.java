package com.linkey.core.domain.dto;

import com.linkey.core.domain.entity.GitUser;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GitUserDto {
    private long githubUserId;
    private String githubUserName;
    private String githubProfileUrl;
    private String githubUserEmail;
    private String githubReposUrl;
    private LocalDateTime githubUpdatedAt;
    private LocalDateTime updatedAt;
    private LocalDateTime createdAt;

    public static GitUserDto fromEntity(GitUser gitUser) {
        return GitUserDto.builder()
                .githubUserId(gitUser.getGithubUserId())
                .githubUserName(gitUser.getGithubUserName())
                .githubProfileUrl(gitUser.getGithubProfileUrl())
                .githubUserEmail(gitUser.getGithubUserEmail())
                .githubReposUrl(gitUser.getGithubReposUrl())
                .githubUpdatedAt(gitUser.getGithubUpdatedAt())
                .updatedAt(gitUser.getUpdatedAt())
                .createdAt(gitUser.getCreatedAt())
                .build();
    }
}
