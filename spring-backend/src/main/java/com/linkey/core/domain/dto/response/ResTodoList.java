package com.linkey.core.domain.dto.response;

import com.linkey.core.domain.entity.Todo;
import com.linkey.core.domain.enums.TodoDoneYn;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
public class ResTodoList {
    private List<SingleTodo> todos;

    @Builder
    @ToString
    @AllArgsConstructor
    public static class SingleTodo {
        long todoId;
        String todoContents;
        TodoDoneYn todoDoneYn;
        SingleUser user;
    }

    @Builder
    @ToString
    @AllArgsConstructor
    public static class SingleUser {
        long githubUserId;
    }

    public static ResTodoList fromEntity(List<Todo> todoEntityList) {

        return ResTodoList.builder()
                .todos(
                        todoEntityList.stream()
                                .map((todoEntity)-> SingleTodo.builder()
                                        .todoId(todoEntity.getTodoId())
                                        .todoContents(todoEntity.getTodoContents())
                                        .todoDoneYn(
                                                TodoDoneYn.getLabel(todoEntity.getTodoDoneYn())
                                        ).user(
                                                SingleUser.builder()
                                                        .githubUserId(todoEntity.getCreatedUser().getGithubUserId())
                                                        .build()
                                        ).build()
                                ).toList()
                ).build();
    }
}

/*

 */