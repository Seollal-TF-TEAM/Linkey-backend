package com.linkey.core.domain.dto;

import com.linkey.core.domain.entity.Sprint;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SprintDto {
    private Long sprintId;
    private String sprintName;
    private String sprintContents;
    private Integer projectId;
    private LocalDate sprintStartAt;
    private LocalDate sprintEndAt;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static SprintDto fromEntity(Sprint sprint) {
        return SprintDto.builder()
                .sprintId(sprint.getSprintId())
                .sprintName(sprint.getSprintName())
                .sprintContents(sprint.getSprintContents())
                .projectId(sprint.getProject() != null ? Integer.valueOf(sprint.getProject().getProjectId()) : null)
                .sprintStartAt(sprint.getSprintStartAt())
                .sprintEndAt(sprint.getSprintEndAt())
                .createdAt(sprint.getCreatedAt())
                .updatedAt(sprint.getUpdatedAt())
                .build();
    }
}
