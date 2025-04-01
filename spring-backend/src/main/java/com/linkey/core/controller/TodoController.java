package com.linkey.core.controller;

import com.linkey.core.domain.dto.TodoDto;
import com.linkey.core.domain.dto.request.ReqCreateTodoDto;
import com.linkey.core.domain.dto.request.ReqUpdateTodoDto;
import com.linkey.core.service.todo.TodoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/todos/")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService){
        this.todoService = todoService;
    }

    @GetMapping("todoList")
    @ResponseBody
    public List<TodoDto> getTodos(@RequestParam("sprintId") Long sprintId) {
        return todoService.getTodos(sprintId);
    }

    @PostMapping("createTodo")
    @ResponseBody
    public Boolean createTodo(@RequestParam("sprintId") Long sprintId,
                              @RequestBody ReqCreateTodoDto todoDto) {
        return todoService.createTodo(sprintId, todoDto);
    }

    @PatchMapping("updateTodo")
    @ResponseBody
    public Boolean updateTodo(@RequestParam("sprintId") Long sprintId,
                              @RequestParam("todoId") Long todoId,
                              @RequestBody ReqUpdateTodoDto todoDto) {
        return todoService.updateTodo(sprintId, todoId, todoDto);
    }

    @DeleteMapping("deleteTodo")
    @ResponseBody
    public Boolean deleteTodo(@RequestParam("todoId") Long todoId) {
        return todoService.deleteTodo(todoId);
    }
}
