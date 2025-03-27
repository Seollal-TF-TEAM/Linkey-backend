package com.linkey.core.domain.entity;

import com.linkey.core.domain.dto.SprintDto;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Builder
@AllArgsConstructor
@Table(name = "sprints")
public class Sprint {

    public Sprint(Long sprintId) {
        this.sprintId = sprintId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sprint_seq")
    @SequenceGenerator(name = "sprint_seq", sequenceName = "sprint_seq_id", allocationSize = 1)
    private Long sprintId;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String sprintName;

    @Column(columnDefinition = "TEXT")
    private String sprintContents;

    @ManyToOne
    @JoinColumn(name = "projectId", nullable = false)
    private Project project; // FK (projects.project_id)

    @Column(nullable = false, columnDefinition = "DATE DEFAULT CURRENT_DATE")
    private LocalDate sprintStartAt;

    @Column(nullable = false, columnDefinition = "DATE DEFAULT CURRENT_DATE")
    private LocalDate sprintEndAt;

    @Column(nullable = true , updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;

    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime updatedAt;

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

    public static Sprint toEntity(SprintDto dto) {
        return Sprint.builder()
                .sprintId(dto.getSprintId())
                .sprintName(dto.getSprintName())
                .sprintContents(dto.getSprintContents())
                .project(dto.getProjectId() != null ? new Project(dto.getProjectId()) : null)
                .sprintStartAt(dto.getSprintStartAt())
                .sprintEndAt(dto.getSprintEndAt())
                .createdAt(dto.getCreatedAt() != null ? dto.getCreatedAt() : LocalDateTime.now())
                .updatedAt(dto.getUpdatedAt() != null ? dto.getUpdatedAt() : LocalDateTime.now())
                .build();
    }


    public void updateFromDto(SprintDto dto) {
        if (dto.getSprintName() != null) {
            this.sprintName = dto.getSprintName();
        }

        if (dto.getSprintContents() != null) {
            this.sprintContents = dto.getSprintContents();
        }

        if (dto.getSprintStartAt() != null) {
            this.sprintStartAt = dto.getSprintStartAt();
        }

        if (dto.getSprintEndAt() != null) {
            this.sprintEndAt = dto.getSprintEndAt();
        }

        this.updatedAt = LocalDateTime.now(); // 수정 시점 갱신

    }

}
