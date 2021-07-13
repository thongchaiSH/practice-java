package com.tutorial.feign.service;

import com.tutorial.feign.client.JSONPlaceHolderClient;
import com.tutorial.feign.models.Todo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class TodoService {

    @Autowired
    private JSONPlaceHolderClient jsonPlaceHolderClient;

    public List<Todo> getAllTodos(){
        log.info("fetching all todo items");
        return jsonPlaceHolderClient.getAllTodos();
    }

    public Todo getSingleTodo(String number){
        log.info("fetching todo item {}", number);
        return jsonPlaceHolderClient.getSingleTodo(number);
    }
    public Todo createTodo(Todo item){
        log.info("creating todo item {}", item);
        return jsonPlaceHolderClient.createTodo(item);
    }

}
