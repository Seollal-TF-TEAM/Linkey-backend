package com.linkey.core.domain.entity;

import com.linkey.core.domain.dto.CommitDto;
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
@Table(name = "commits")
public class Commit {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "img_seq")
    @SequenceGenerator(name = "img_seq", sequenceName = "img_seq_id", allocationSize = 1)
    private Integer commitId;

    @Column(nullable = false, length = 100)
    private String githubCommitSha;

    @Column(columnDefinition = "TEXT")
    private String githubCommitMessage;

    @Column(nullable = false)
    private Long githubCommitUserId; // FK 아님

    @Column(nullable = false, columnDefinition = "TIMESTAMP")
    private LocalDateTime githubCommitDate;

    @ManyToOne
    @JoinColumn(name = "todoId", nullable = false)
    private Todo todo; // FK (todos.todo_id)

    @Column(nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;

    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime updatedAt;

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

    public static Commit toEntity(CommitDto dto) {
        return Commit.builder()
                .githubCommitSha(dto.getGithubCommitSha())
                .githubCommitMessage(dto.getGithubCommitMessage())
                .githubCommitUserId(dto.getGithubCommitUserId())
                .githubCommitDate(dto.getGithubCommitDate())
                .todo(new Todo(dto.getTodoId()))
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
    }

}
