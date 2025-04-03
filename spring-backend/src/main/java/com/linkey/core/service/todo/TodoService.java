package com.linkey.core.service.todo;

import com.linkey.core.domain.dto.TodoDto;
import com.linkey.core.domain.dto.request.ReqCreateTodoDto;
import com.linkey.core.domain.dto.request.ReqUpdateTodoDto;

import java.util.List;

public interface TodoService {
    List<TodoDto> getTodos(Long sprintId);
    Boolean createTodo(Long sprintId, ReqCreateTodoDto todoDto);
    Boolean updateTodo(Long sprintId, Long todoId, ReqUpdateTodoDto todoDto);
    Boolean deleteTodo(Long todoId);
}
