package com.mascot.todoapp;


import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {

    private final List<String> todos = new ArrayList<>();

    public List<String> getTodos() {
        return todos;
    }

    public void addTodo(String todo) {
        if (!todo.trim().isEmpty()) {
            todos.add(todo);
        }
    }

    public void deleteTodo(int index) {
        if (index >= 0 && index < todos.size()) {
            todos.remove(index);
        }
    }
}