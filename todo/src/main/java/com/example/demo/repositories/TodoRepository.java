package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.repository.ListCrudRepository;

import com.example.demo.models.StatusType;
import com.example.demo.models.Todo;


public interface TodoRepository extends ListCrudRepository<Todo, Long>{
    List<Todo> findByStatusType(StatusType statusType);
}
