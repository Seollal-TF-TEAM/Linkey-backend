package com.linkey.core.domain.dto;

import com.linkey.core.domain.entity.Todo;
import com.linkey.core.domain.enums.TodoLevel;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TodoDto {
    private Long todoId;
    private String todoContents;
    private Character todoDoneYn;
    private TodoLevel todoLevel;
    private Long sprintId;
    private Long createdUserId;
    private String createdUserName;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static TodoDto fromEntity(Todo todo) {
        return TodoDto.builder()
                .todoId(todo.getTodoId())
                .todoContents(todo.getTodoContents())
                .todoDoneYn(todo.getTodoDoneYn())
                .todoLevel(todo.getTodoLevel())
                .sprintId(todo.getSprint() != null ? todo.getSprint().getSprintId() : null)
                .createdUserId(todo.getCreatedUser() != null ? todo.getCreatedUser().getGithubUserId() : null)
                .createdUserName(todo.getCreatedUser() != null ? todo.getCreatedUser().getGithubUserName() : null)
                .createdAt(todo.getCreatedAt())
                .updatedAt(todo.getUpdatedAt())
                .build();
    }
}
