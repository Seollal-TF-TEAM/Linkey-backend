package com.linkey.core.domain;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "commits")
public class Commit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer commitId;

    @Column(nullable = false, length = 255)
    private String githubCommitSha;

    @Column(columnDefinition = "TEXT")
    private String githubCommitMessage;

    @Column(nullable = false)
    private Long githubCommitUserId; // FK 아님

    @Column(nullable = false, columnDefinition = "TIMESTAMP")
    private LocalDateTime githubCommitDate;

    @ManyToOne
    @JoinColumn(name = "todo_id", nullable = false)
    private Todo todo; // FK (todos.todo_id)

    @Column(nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;

    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private LocalDateTime updatedAt;
}
