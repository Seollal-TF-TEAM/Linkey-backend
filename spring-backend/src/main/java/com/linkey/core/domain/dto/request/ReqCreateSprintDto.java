package com.linkey.core.domain.dto.request;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
public class ReqCreateSprintDto {
    private String sprintName;
    private String sprintContent;
    private LocalDateTime sprintStartAt;
    private LocalDateTime sprintEndAt;
    private SingleProject project;
    private SingleImage sprintImg;

    @Builder
    @ToString
    @AllArgsConstructor
    public static class SingleProject {
        int projectId;
    }

    @Builder
    @ToString
    @AllArgsConstructor
    public static class SingleImage {
        int imageId;
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
                .sprintImg(
                        ReqCreateSprintDto.SingleImage.builder()
                                .imageId(111)
                                .build()
                );
 */