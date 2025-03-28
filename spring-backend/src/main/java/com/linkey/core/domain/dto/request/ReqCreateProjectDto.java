package com.linkey.core.domain.dto.request;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
public class ReqCreateProjectDto {
    private String projectName;
    private String projectDesc;
    private String githubRepoUrl;
    private SingleTeam team;

    @Getter
    @Builder
    @ToString
    @AllArgsConstructor
    public static class SingleTeam {
        int teamId;
    }
}
/*
예시 :
    ReqCreateProjectDto.builder()
                .projectName("name")
                .projectDesc("desc")
                .githubRepoUrl("url")
                .team(
                        ReqCreateProjectDto.SingleTeam.builder()
                                .teamId(4)
                                .build()
                );
 */