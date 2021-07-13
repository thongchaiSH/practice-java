package com.tutorial.feign.client;

import com.tutorial.feign.models.Todo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(
    value = "JSONPlaceHolderClient", url = "${json.place.holder.base.url}"
)
public interface JSONPlaceHolderClient {

    @GetMapping("todos")
    List<Todo> getAllTodos();

    @GetMapping("todos/{number}")
    Todo getSingleTodo(@PathVariable String number);

    @PostMapping("todos")
    Todo createTodo(@RequestBody Todo item);
}
