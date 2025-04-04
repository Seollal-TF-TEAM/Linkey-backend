package com.linkey.core.domain.dto.request;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
public class ReqCreateSprintDto {
    private String sprintName;
    private String sprintContent;
    private LocalDate sprintStartAt;
    private LocalDate sprintEndAt;
    private SingleProject project;

    @Getter
    @Builder
    @ToString
    @AllArgsConstructor
    public static class SingleProject {
        int projectId;
    }

}
/*
예시 :
    ReqCreateSprintDto.builder()
                .sprintName("name")
                .sprintContent("content")
                .sprintStartAt(LocalDateTime.now())
                .sprintEndAt(LocalDateTime.now())
                .project(
                        ReqCreateSprintDto.SingleProject.builder()
                                .projectId(123)
                                .build()
                )
 */