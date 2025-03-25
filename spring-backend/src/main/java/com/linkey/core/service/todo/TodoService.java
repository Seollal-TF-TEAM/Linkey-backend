package com.linkey.core.service.todo;

import com.linkey.core.domain.dto.TodoDto;
import com.linkey.core.domain.dto.request.ReqCreateTodoDto;
import com.linkey.core.repository.sprint.SprintRepository;
import com.linkey.core.repository.todo.TodoRepository;
import com.linkey.core.repository.user.GitUserRepository;

public interface TodoService {
    public Boolean addTodo(TodoDto todo);

}
