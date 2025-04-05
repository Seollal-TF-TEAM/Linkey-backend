package com.linkey.core.domain.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
public class ReqCreateSprintDto {
    @NotBlank(message = "스프린트 이름은 필수 입력 값입니다.")
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