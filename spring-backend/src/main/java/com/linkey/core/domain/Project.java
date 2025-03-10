package com.linkey.core.domain;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer projectId;

    @Column(nullable = false)
    private String projectName;

    @Column(columnDefinition = "TEXT")
    private String projectDesc;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "teamId", referencedColumnName = "teamId", nullable = false),
            @JoinColumn(name = "teamSeqId", referencedColumnName = "teamSeqId", nullable = false)
    })
    private TeamMember teamMember; // FK (team_members.team_id)

    @Column
    private String githubRepoUrl;

    @Column(nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;

    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private LocalDateTime updatedAt;
}
