package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.models.StatusType;
import com.example.demo.models.Todo;
import com.example.demo.services.TodoService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;


@Controller
@RequiredArgsConstructor
public class TodoFormController {
    final TodoService todoService;
    
    @PostMapping("/todos/new")
    public String createTodo(@Valid Todo newTodo) {
        newTodo.setStatusType(StatusType.BACKLOG);
        todoService.save(newTodo);
        
        
        return "redirect:/";
    }
    
}
