package com.linkey.core.domain.dto;

import com.linkey.core.domain.entity.Project;
import com.linkey.core.domain.entity.Team;
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
    private Team team; // FK (team_members.team_id)
    private String githubRepoUrl;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static ProjectDto fromEntity(Project project) {
        return ProjectDto.builder()
                .projectId(project.getProjectId())
                .projectName(project.getProjectName())
                .projectDesc(project.getProjectDesc())
                .team(project.getTeam())
                .githubRepoUrl(project.getGithubRepoUrl())
                .createdAt(project.getCreatedAt())
                .updatedAt(project.getUpdatedAt())
                .build();
    }
}
