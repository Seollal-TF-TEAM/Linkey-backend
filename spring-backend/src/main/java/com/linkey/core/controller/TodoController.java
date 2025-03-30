package com.linkey.core.controller;

import com.linkey.core.domain.dto.TodoDto;
import com.linkey.core.domain.dto.request.ReqCreateTodoDto;
import com.linkey.core.domain.dto.request.ReqUpdateTodoDto;
import com.linkey.core.service.todo.TodoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/sprints/{sprintId}/todos")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService){
        this.todoService = todoService;
    }

    @GetMapping
    @ResponseBody
    public List<TodoDto> getTodos(@PathVariable Long sprintId) {
        return todoService.getTodos(sprintId);
    }

    @PostMapping
    @ResponseBody
    public Boolean createTodo(@PathVariable Long sprintId,
                              @RequestBody ReqCreateTodoDto todoDto) {
        return todoService.createTodo(sprintId, todoDto);
    }

    @PatchMapping("/{todoId}")
    @ResponseBody
    public Boolean updateTodo(@PathVariable Long sprintId,
                              @PathVariable Long todoId,
                              @RequestBody ReqUpdateTodoDto todoDto) {
        return todoService.updateTodo(sprintId, todoId, todoDto);
    }

    @DeleteMapping("/{todoId}")
    @ResponseBody
    public Boolean deleteTodo(@PathVariable Long sprintId,
                              @PathVariable Long todoId) {
        return todoService.deleteTodo(todoId);
    }
}
