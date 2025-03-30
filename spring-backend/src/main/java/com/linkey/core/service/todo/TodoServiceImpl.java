package com.linkey.core.service.todo;

import com.linkey.core.domain.dto.TodoDto;
import com.linkey.core.domain.dto.request.ReqCreateTodoDto;
import com.linkey.core.domain.dto.request.ReqUpdateTodoDto;
import com.linkey.core.domain.entity.GitUser;
import com.linkey.core.domain.entity.Sprint;
import com.linkey.core.domain.entity.Todo;
import com.linkey.core.global.exception.CustomException;
import com.linkey.core.global.exception.ErrorCode;
import com.linkey.core.repository.todo.TodoRepository;
import com.linkey.core.repository.user.GitUserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class TodoServiceImpl implements TodoService{

    private final TodoRepository todoRepository;
    private final GitUserRepository gitUserRepository;

    public TodoServiceImpl(TodoRepository todoRepository, GitUserRepository gitUserRepository, GitUserRepository gitUserRepository1){
        this.todoRepository = todoRepository;
        this.gitUserRepository = gitUserRepository1;
    }

    @Override
    public Boolean createTodo(Long sprintId, ReqCreateTodoDto request) {
        Sprint sprint = Sprint.builder()
                .sprintId((long) request.getSprint().getSprintId())
                .build();

        GitUser user = gitUserRepository.findByGithubUserId(request.getGithubUserId())
                .orElseThrow(() -> new CustomException(ErrorCode.TODO_INVALID_USER));

        Todo todo = Todo.toEntity(request, sprint, user);
        todoRepository.save(todo);

        return true;
    }
    @Override
    public List<TodoDto> getTodos(Long sprintId) {
        return todoRepository.findBySprint_SprintId(sprintId).stream()
                .map(TodoDto::fromEntity)
                .toList();
    }

    @Override
    @Transactional
    public Boolean updateTodo(Long sprintId, Long todoId, ReqUpdateTodoDto request) {
        Todo todo = todoRepository.findByTodoId(todoId)
                .orElseThrow(() -> new CustomException(ErrorCode.TODO_NOT_FOUND));

        GitUser user = gitUserRepository.findByGithubUserId(request.getGithubUserId())
                .orElseThrow(() -> new CustomException(ErrorCode.TODO_INVALID_USER));

        todo.updateFromDto(request, user);

        return true;
    }

    @Override
    public Boolean deleteTodo(Long todoId) {
        Todo todo = todoRepository.findByTodoId(todoId)
                .orElseThrow(() -> new CustomException(ErrorCode.TODO_NOT_FOUND));

        todoRepository.delete(todo);
        return true;
    }

}
