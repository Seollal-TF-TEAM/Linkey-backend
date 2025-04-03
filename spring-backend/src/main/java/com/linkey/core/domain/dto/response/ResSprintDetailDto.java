package com.linkey.core.domain.dto.response;

import com.linkey.core.domain.entity.Sprint;
import com.linkey.core.domain.entity.Todo;
import com.linkey.core.domain.enums.TodoDoneYn;
import com.linkey.core.domain.enums.TodoLevel;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
public class ResSprintDetailDto {
    private String sprintName;
    private String sprintContents;
    private LocalDate sprintStartAt;
    private LocalDate sprintEndAt;
    private SingleProject project;
    private List<SingleTodo> todos;

    @Getter
    @Builder
    @ToString
    @AllArgsConstructor
    public static class SingleProject {
        int projectId;
    }

    @Getter
    @Builder
    @ToString
    @AllArgsConstructor
    public static class SingleTodo {
        long todoId;
        String todoContents;
        TodoDoneYn todoDoneYn;
        TodoLevel todoLevel;
        SingleUser user;
    }

    @Getter
    @Builder
    @ToString
    @AllArgsConstructor
    public static class SingleUser {
        long githubUserId;
    }

    public static ResSprintDetailDto fromEntity(Sprint sprintEntity, List<Todo> todoEntityList) {

        return ResSprintDetailDto.builder()
                .sprintName(sprintEntity.getSprintName())
                .sprintContents(sprintEntity.getSprintContents())
                .sprintStartAt(sprintEntity.getSprintStartAt())
                .sprintEndAt(sprintEntity.getSprintEndAt())
                .project(
                        SingleProject.builder()
                                .projectId(sprintEntity.getProject().getProjectId())
                                .build()
                ).todos(
                    todoEntityList.stream()
                            .map((todoEntity) -> SingleTodo.builder()
                                    .todoId(todoEntity.getTodoId())
                                    .todoContents(todoEntity.getTodoContents())
                                    .todoDoneYn(
                                            TodoDoneYn.getLabel(todoEntity.getTodoDoneYn())
                                    )
                                    .todoLevel(todoEntity.getTodoLevel())
                                    .user(
                                            SingleUser.builder()
                                                    .githubUserId(todoEntity.getCreatedUser().getGithubUserId())
                                                    .build()
                                    ).build()
                            ).toList()
                ).build();
    }
}

/*
예시 :
    ResSprintDetailDto.builder()
                .todos(List.of(
                        ResSprintDetailDto.SingleTodo.builder()
                                .todoId(1234)
                                .todoContents("contents")
                                .todoLevel(TodoLevel.H)
                                .todoDoneYn(TodoDoneYn.N)
                                .user(
                                        ResSprintDetailDto.SingleUser.builder()
                                                .githubUserId(123L)
                                                .build()
                                )
                                .build()
                ))
                .build();
 */