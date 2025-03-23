package com.linkey.core.domain.dto.response;

import com.linkey.core.domain.entity.Project;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor

public class ResProjectListDto {
    private List<SingleProject> projects;

    @Builder
    public static class SingleProject {
        int projectId;
        String projectName;
        String teamName;
    }

    public static ResProjectListDto fromEntity(List<Project> projectEntityList) {

        return ResProjectListDto.builder()
                .projects(
                        projectEntityList.stream()
                                .map((projectEntity) ->
                                    SingleProject.builder()
                                            .projectId(projectEntity.getProjectId())
                                            .projectName(projectEntity.getProjectName())
                                            .teamName(projectEntity.getTeam().getTeamName())
                                            .build()
                                ).toList()
                ).build();
    }
}
/*
예시 :
    ResProjectListDto.builder()
                .projects(List.of(
                   ResProjectListDto.SingleProject.builder()
                        .projectId(123)
                        .projectName("name")
                        .teamName("teamName")
                        .build()
                 ));
                 .build();
 */
