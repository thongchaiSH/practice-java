package com.tutorial.feign.controller;

import com.tutorial.feign.models.Todo;
import com.tutorial.feign.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("todo-list")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping("")
    public List<Todo> getAllTodos(){
        return todoService.getAllTodos();
    }

    @GetMapping("{number}")
    public Todo getSingleTodo(@PathVariable String number){
        return todoService.getSingleTodo(number);
    }

    @PostMapping("")
    public Todo createTodo(@RequestBody Todo item){
        return todoService.createTodo(item);
    }
}
