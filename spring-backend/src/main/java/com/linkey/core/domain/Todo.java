package com.linkey.core.domain;

import com.linkey.core.domain.enums.TodoLevel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "todos")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long todoId;

    @Column(columnDefinition = "TEXT")
    private String todoContents;

    @Column(nullable = false, columnDefinition = "CHAR DEFAULT 'N'")
    private Character todoDoneYn; // 'N' 기본값

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TodoLevel todoLevel; // ENUM (L, M, H)

    @ManyToOne
    @JoinColumn(name = "sprint_id", nullable = false)
    private Sprint sprint; // FK (sprints.sprint_id)

    @ManyToOne
    @JoinColumn(name = "created_user_id", nullable = false)
    private User createdUser; // FK (users.github_user_id)

    @Column(nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;

    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private LocalDateTime updatedAt;
}
