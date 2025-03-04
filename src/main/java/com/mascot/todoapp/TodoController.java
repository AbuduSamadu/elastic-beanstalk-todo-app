package com.mascot.todoapp;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/")
    public String showTodos(Model model) {
        List<String> todos = todoService.getTodos();
        model.addAttribute("todos", todos);
        return "todo-list";
    }

    @PostMapping("/add")
    public String addTodo(@RequestParam String todo) {
        todoService.addTodo(todo);
        return "redirect:/";
    }

    @PostMapping("/delete/{index}")
    public String deleteTodo(@PathVariable int index) {
        todoService.deleteTodo(index);
        return "redirect:/";
    }
}