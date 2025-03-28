package com.linkey.core.service.todo;

import com.linkey.core.domain.dto.TodoDto;
import com.linkey.core.domain.dto.request.ReqCreateTodoDto;
import com.linkey.core.domain.dto.request.ReqUpdateTodoDto;

import java.util.List;

public interface TodoService {

    public List<TodoDto> getTodos(Long sprintId);

    public Boolean createTodo(Long sprintId, ReqCreateTodoDto todoDto);

    public Boolean updateTodo(Long sprintId, Long todoId, ReqUpdateTodoDto todoDto);

    public Boolean deleteTodo(Integer todoId);

}
