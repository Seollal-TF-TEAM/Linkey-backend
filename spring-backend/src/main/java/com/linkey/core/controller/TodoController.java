package com.linkey.core.controller;

import com.linkey.core.domain.dto.TodoDto;
import com.linkey.core.domain.dto.request.ReqCreateTodoDto;
import com.linkey.core.domain.dto.request.ReqUpdateTodoDto;
import com.linkey.core.domain.dto.response.ResWrapper;
import com.linkey.core.global.exception.CustomException;
import com.linkey.core.service.todo.TodoService;
import org.springframework.security.core.parameters.P;
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
    public ResWrapper getTodos(@RequestParam("sprintId") Long sprintId) {
        try {
            List<TodoDto> todoDtoList = todoService.getTodos(sprintId);
            return ResWrapper.resSuccess(todoDtoList);
        } catch (CustomException e) {
            return ResWrapper.resCustomException(e);
        }
    }

    @PostMapping("createTodo")
    @ResponseBody
    public ResWrapper createTodo(@RequestParam("sprintId") Long sprintId,
                              @RequestBody ReqCreateTodoDto todoDto) {
        try {
            boolean result = todoService.createTodo(sprintId, todoDto);
            return ResWrapper.resSuccess(result);
        } catch (CustomException e) {
            return ResWrapper.resCustomException(e);
        }
    }

    @PatchMapping("updateTodo")
    @ResponseBody
    public ResWrapper updateTodo(@RequestParam("sprintId") Long sprintId,
                              @RequestParam("todoId") Long todoId,
                              @RequestBody ReqUpdateTodoDto todoDto) {
        try {
            boolean result = todoService.updateTodo(sprintId, todoId, todoDto);
            return ResWrapper.resSuccess(result);
        } catch (CustomException e) {
            return ResWrapper.resCustomException(e);
        }
    }

    @DeleteMapping("deleteTodo")
    @ResponseBody
    public ResWrapper deleteTodo(@RequestParam("todoId") Long todoId) {
        try {
            boolean result = todoService.deleteTodo(todoId);
            return ResWrapper.resSuccess(result);
        } catch (CustomException e) {
            return ResWrapper.resCustomException(e);
        }
    }
}
