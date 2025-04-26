package com.example.demo.config;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.models.StatusType;
import com.example.demo.models.Todo;
import com.example.demo.services.TodoService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class SeedData implements CommandLineRunner{
    final  TodoService todoService;

    @Override
    public void run(String... args) throws Exception{
        List<Todo> todos = todoService.getAll();
        if(todos.isEmpty()){
            Todo todo1 = Todo.builder().description("edit tutorial").statusType(StatusType.BACKLOG).build();
            Todo todo2 = Todo.builder().description("shoot tutorial").statusType(StatusType.DOING).build();
            Todo todo3 = Todo.builder().description("tutorial script").statusType(StatusType.DONE).build();

            todoService.save(todo1);
            todoService.save(todo2);
            todoService.save(todo3);
        }
    }
}
