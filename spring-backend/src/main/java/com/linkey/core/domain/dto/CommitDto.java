package com.linkey.core.domain.dto;

import com.linkey.core.domain.entity.Commit;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommitDto {
    private Integer commitId;
    private String githubCommitSha;
    private String githubCommitMessage;
    private Long githubCommitUserId;
    private LocalDateTime githubCommitDate;
    private Long todoId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static CommitDto fromEntity(Commit commit) {
        return CommitDto.builder()
                .commitId(commit.getCommitId())
                .githubCommitSha(commit.getGithubCommitSha())
                .githubCommitMessage(commit.getGithubCommitMessage())
                .githubCommitUserId(commit.getGithubCommitUserId())
                .githubCommitDate(commit.getGithubCommitDate())
                .todoId(commit.getTodo().getTodoId())
                .createdAt(commit.getCreatedAt())
                .updatedAt(commit.getUpdatedAt())
                .build();
    }
}
