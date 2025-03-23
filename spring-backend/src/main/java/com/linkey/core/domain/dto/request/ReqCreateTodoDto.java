package com.linkey.core.domain.dto.request;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
public class ReqCreateTodoDto {
    private String todoName;
    private String todoContent;
    private LocalDateTime todoStartAt;
    private LocalDateTime todoEndAt;
    private SingleSprint sprint;

    @Builder
    @ToString
    @AllArgsConstructor
    public static class SingleSprint {
        int sprintId;
    }
}

/*
예시 :
    ReqCreateTodoDto.builder()
                .todoName("name")
                .todoContent("content")
                .todoStartAt(LocalDateTime.now())
                .todoEndAt(LocalDateTime.now())
                .sprint(
                        ReqCreateTodoDto.SingleSprint.builder()
                                .sprintId(123)
                                .build()
                )
                .build();
 */