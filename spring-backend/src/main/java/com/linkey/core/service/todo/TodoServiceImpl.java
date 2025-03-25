package com.linkey.core.service.todo;

import com.linkey.core.domain.dto.TodoDto;
import com.linkey.core.domain.entity.Todo;
import com.linkey.core.repository.sprint.SprintRepository;
import com.linkey.core.repository.todo.TodoRepository;
import com.linkey.core.repository.user.GitUserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class TodoServiceImpl implements TodoService{

    private final TodoRepository todoRepo;
    private final GitUserRepository gitUserRepo;
    private final SprintRepository sprintRepo;

    public TodoServiceImpl(TodoRepository todoRepo, SprintRepository sprintRepo, GitUserRepository gitUserRepo){
        this.todoRepo = todoRepo;
        this.gitUserRepo = gitUserRepo;
        this.sprintRepo = sprintRepo;
    }

    @Override
    public Boolean addTodo(TodoDto todo){
        Todo todoEntitiy = Todo.toEntity(todo);
        Todo saveTodo = Optional.of(todoRepo.save(todoEntitiy))
                .orElseThrow(() -> new IllegalArgumentException("save Fail"));

        return true;
    }
}
