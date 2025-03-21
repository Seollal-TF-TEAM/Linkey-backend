package com.linkey.core.domain.entity;

import com.linkey.core.domain.dto.TodoDto;
import com.linkey.core.domain.enums.TodoLevel;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Builder
@AllArgsConstructor
@Table(name = "todos")
public class Todo {

    public Todo(Long todoId) {
        this.todoId = todoId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "todo_seq")
    @SequenceGenerator(name = "todo_seq", sequenceName = "todo_seq_id", allocationSize = 1)
    private Long todoId;

    @Column(columnDefinition = "TEXT")
    private String todoContents;

    @Column(nullable = false, columnDefinition = "CHAR DEFAULT 'N'")
    private Character todoDoneYn; // 'N' 기본값

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TodoLevel todoLevel; // ENUM (L, M, H)

    @ManyToOne
    @JoinColumn(name = "sprintId", nullable = false)
    private Sprint sprint; // FK (sprints.sprint_id)

    @ManyToOne
    @JoinColumn(name = "createdUserId", nullable = false)
    private GitUser createdUser; // FK (users.github_user_id)

    @Column(nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;

    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime updatedAt;

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

    public static Todo toEntity(TodoDto dto) {
        return Todo.builder()
                .todoId(dto.getTodoId())
                .todoContents(dto.getTodoContents())
                .todoDoneYn(dto.getTodoDoneYn())
                .todoLevel(dto.getTodoLevel())
                .sprint(dto.getSprintId() != null ? new Sprint(dto.getSprintId()) : null)
                .createdUser(dto.getCreatedUserId() != null ? new GitUser(dto.getCreatedUserId()) : null)
                .createdAt(dto.getCreatedAt() != null ? dto.getCreatedAt() : LocalDateTime.now())
                .updatedAt(dto.getUpdatedAt() != null ? dto.getUpdatedAt() : LocalDateTime.now())
                .build();
    }

}
