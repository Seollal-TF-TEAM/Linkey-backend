package com.linkey.core.domain.dto.request;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
public class ReqUpdateSprintDto {
    private int sprintId;
    private String sprintName;
    private String sprintContents;
    private LocalDateTime sprintStartAt;
    private LocalDateTime sprintEndAt;
}

/*
예시 :
    ReqUpdateSprintDto.builder()
                .sprintId(1234)
                .sprintName("name")
                .sprintContents("content")
                .sprintStartAt(LocalDateTime.now())
                .sprintEndAt(LocalDateTime.now())
                .build();
 */
