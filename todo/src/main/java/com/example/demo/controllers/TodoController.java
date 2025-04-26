package com.example.demo.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.StatusType;
import com.example.demo.models.Todo;
import com.example.demo.services.TodoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class TodoController {
    final TodoService todoService;

    @PutMapping("/todos/{id}")
    public Todo updateTodoItem(@PathVariable("id") long id){
        Todo updatedTodo = todoService.getById(id);
        if (updatedTodo.getStatusType() == StatusType.BACKLOG) {
            updatedTodo.setStatusType(StatusType.DOING);
        }
        else if (updatedTodo.getStatusType() == StatusType.DOING) {
            updatedTodo.setStatusType(StatusType.DONE);
        }
        return todoService.save(updatedTodo);
    }
}
