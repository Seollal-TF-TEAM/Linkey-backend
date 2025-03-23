package com.linkey.core.domain.dto.request;

import com.linkey.core.domain.enums.TodoDoneYn;
import com.linkey.core.domain.enums.TodoLevel;
import lombok.*;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
public class ReqUpdateTodoDto {
    private int todoId;
    private String todoName;
    private TodoDoneYn todoDoneYn;
    private TodoLevel todoLevel;
    private SingleUser user;

    @Builder
    @ToString
    @AllArgsConstructor
    public static class SingleUser {
        long githubUserId;
    }
}

/*
예시 :
    ReqUpdateTodoDto.builder()
                .todoId(123)
                .todoName("name")
                .todoDoneYn(TodoDoneYn.N)
                .todoLevel(TodoLevel.L)
                .user(
                        ReqUpdateTodoDto.SingleUser.builder()
                                .githubUserId(123L)
                                .build()
                )
                .build();
 */

