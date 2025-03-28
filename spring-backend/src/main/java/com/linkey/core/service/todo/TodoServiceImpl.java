package com.linkey.core.service.todo;

import com.linkey.core.domain.dto.TodoDto;
import com.linkey.core.domain.dto.request.ReqCreateTodoDto;
import com.linkey.core.domain.dto.request.ReqUpdateTodoDto;
import com.linkey.core.repository.todo.TodoRepository;
import com.linkey.core.repository.user.GitUserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class TodoServiceImpl implements TodoService{

    private final TodoRepository todoRepository;

    public TodoServiceImpl(TodoRepository todoRepository, GitUserRepository gitUserRepository){
        this.todoRepository = todoRepository;
    }

    @Override
    public List<TodoDto> getTodos(Long sprintId) {
        return List.of();
    }

    @Override
    public Boolean createTodo(Long sprintId, ReqCreateTodoDto request) {
        return true;
    }

    @Override
    public Boolean updateTodo(Long sprintId, Long todoId, ReqUpdateTodoDto request) {
        return true;
    }

    @Override
    public Boolean deleteTodo(Integer todoId) {
        todoRepository.deleteByTodoId(todoId);
        return true;
    }
}
