package com.linkey.core.domain.dto.response;

import com.linkey.core.domain.entity.Project;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
public class ResProjectDetailDto {
    private int projectId;
    private String projectName;
    private String teamName;
    private String githubRepoUrl;
    private List<SingleTeamMember> teamMembers;

    @Builder
    @AllArgsConstructor
    public static class SingleTeamMember {
        String githubUserName;
        String githubProfileUrl;
    }

    public static ResProjectDetailDto fromEntity(Project projectEntity) {

        return ResProjectDetailDto.builder()
                .projectId(projectEntity.getProjectId())
                .projectName(projectEntity.getProjectName())
                .teamName(projectEntity.getTeam().getTeamName())
                .teamMembers(
                        projectEntity.getTeam().getTeamMembers().stream()
                                .map((teamMember) ->
                                    SingleTeamMember.builder()
                                            .githubUserName(teamMember.getUser().getGithubUserName())
                                            .githubProfileUrl(teamMember.getUser().getGithubProfileUrl())
                                            .build()
                                ).toList()
                ).build();
    }
}
/*
예시 :
    ResProjectDetailDto.builder()
                .projectId(1)
                .projectName("name")
                .teamMembers(List.of (
                        ResProjectDetailDto.SingleTeamMember.builder()
                                .githubUserId(1234L)
                                .build()
                        ))
                .build();
 */