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
public class ReqUpdateTodoDto {
    private String todoName;
    private String todoContent;
    private TodoDoneYn todoDoneYn;
    private TodoLevel todoLevel;
    private LocalDateTime todoStartAt;
    private LocalDateTime todoEndAt;
    private ReqCreateTodoDto.SingleSprint sprint;
    private Long githubUserId;

    @Getter
    @Builder
    @ToString
    @AllArgsConstructor
    public static class SingleUser {
        private Long githubUserId;
    }

    @Getter
    @Builder
    @ToString
    @AllArgsConstructor
    public static class SingleSprint {
        int sprintId;
    }
}
