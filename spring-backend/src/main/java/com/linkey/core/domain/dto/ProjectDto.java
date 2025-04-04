package com.linkey.core.domain.dto;

import com.linkey.core.domain.entity.Project;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ProjectDto {
    private Integer projectId;
    private String projectName;
    private String projectDesc;
    private Integer teamId; // FK (team_members.team_id)
    private String githubRepoUrl;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static ProjectDto fromEntity(Project project) {
        return ProjectDto.builder()
                .projectId(project.getProjectId())
                .projectName(project.getProjectName())
                .projectDesc(project.getProjectDesc())
                .teamId(project.getTeam().getTeamId())
                .githubRepoUrl(project.getGithubRepoUrl())
                .createdAt(project.getCreatedAt())
                .updatedAt(project.getUpdatedAt())
                .build();
    }
}
