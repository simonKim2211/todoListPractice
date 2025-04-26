package com.example.demo.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.models.StatusType;
import com.example.demo.models.Todo;
import com.example.demo.repositories.TodoRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TodoService {
    final TodoRepository todoRepository;

    public List<Todo> getAll() { return todoRepository.findAll() ;}

    public List<Todo> getAllByStatus(StatusType status){
        return todoRepository.findByStatusType(status);
    }

    public Todo getById(Long id){
        return todoRepository.findById(id).orElseThrow();
    }

    public Todo save(Todo newTodo){
        if(newTodo.getId() == null){
            newTodo.setCreatedAt(LocalDateTime.now());
        }

        newTodo.setUpdatedAt(LocalDateTime.now());
        return todoRepository.save(newTodo);
    }
}
