package com.linkey.core.domain.dto.request;

import com.linkey.core.domain.dto.TodoDto;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReqCreateCommitDto {
    private Integer commitId;
    private String githubCommitSha;
    private String githubCommitMessage;
    private Long githubCommitUserId; // FK 아님
    private LocalDateTime githubCommitDate;
    private TodoDto todo; // FK (todos.todo_id)
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
