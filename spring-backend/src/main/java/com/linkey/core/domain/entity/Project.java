package com.linkey.core.domain.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Builder
@AllArgsConstructor
@Table(name = "projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "projects_seq")
    @SequenceGenerator(name = "projects_seq", sequenceName = "projects_id_seq", allocationSize = 1)
    private Integer projectId;

    @NonNull
    @Column(nullable = false, columnDefinition = "TEXT")
    private String projectName;

    @NonNull
    @Column(nullable = false, columnDefinition = "TEXT")
    private String projectDesc;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "teamId", nullable = false)
    private Team team; // FK (team_members.team_id)

    @NonNull
    @Column(columnDefinition = "TEXT")
    private String githubRepoUrl;

    @Column(nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;

    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime updatedAt;


    @PreUpdate
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

}
