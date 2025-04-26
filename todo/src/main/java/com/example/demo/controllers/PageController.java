package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.models.StatusType;
import com.example.demo.models.Todo;
import com.example.demo.services.TodoService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class PageController {
    final TodoService todoService;

    @GetMapping("/")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("newTodo", new Todo());

        modelAndView.addObject("backlog", todoService.getAllByStatus(StatusType.BACKLOG));
        modelAndView.addObject("doing", todoService.getAllByStatus(StatusType.DOING));
        modelAndView.addObject("done", todoService.getAllByStatus(StatusType.DONE));
        return modelAndView;
    }

}
