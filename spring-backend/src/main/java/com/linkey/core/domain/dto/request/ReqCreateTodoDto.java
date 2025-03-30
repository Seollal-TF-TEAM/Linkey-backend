package com.linkey.core.domain.dto.request;

import com.linkey.core.domain.enums.TodoDoneYn;
import com.linkey.core.domain.enums.TodoLevel;
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
    private TodoDoneYn todoDoneYn;
    private TodoLevel todoLevel;
    private LocalDateTime todoStartAt;
    private LocalDateTime todoEndAt;
    private SingleSprint sprint;
    private Long githubUserId; // 👈 담당자 ID 추가!

    @Getter
    @Builder
    @ToString
    @AllArgsConstructor
    public static class SingleSprint {
        int sprintId;
    }
}
