//package com.linkey.core.controller;
//
//import com.linkey.core.domain.dto.TodoDto;
//import com.linkey.core.domain.dto.request.ReqCreateTodoDto;
//import com.linkey.core.service.todo.TodoService;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//
//@Controller
//@RequestMapping("/api/todo")
//public class TodoController {
//
//    private final TodoService todoService;
//
//    public TodoController(TodoService todoService) {this.todoService = todoService;}
//
//    @PostMapping
//    @ResponseBody
//    public Boolean createTodo(@RequestBody TodoDto todo){
//        return todoService.addTodo(todo);
//    }
//}
