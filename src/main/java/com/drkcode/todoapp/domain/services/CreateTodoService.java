package com.drkcode.todoapp.domain.services;

import com.drkcode.todoapp.domain.model.Todo;
import com.drkcode.todoapp.domain.model.TodoId;
import com.drkcode.todoapp.domain.repositories.CreateTodoRepository;

public class CreateTodoService {

    private final CreateTodoRepository repository;

    public CreateTodoService(CreateTodoRepository repository) {
        this.repository = repository;
    }

    public TodoId execute(Todo todo) {
        return repository.execute(todo);
    }
}
