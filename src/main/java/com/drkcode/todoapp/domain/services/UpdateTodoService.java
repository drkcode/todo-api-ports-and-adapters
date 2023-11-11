package com.drkcode.todoapp.domain.services;

import com.drkcode.todoapp.domain.exceptions.TodoNotFoundException;
import com.drkcode.todoapp.domain.model.Todo;
import com.drkcode.todoapp.domain.repositories.UpdateTodoRepository;

public class UpdateTodoService {

    private final UpdateTodoRepository updateTodoRepository;

    public UpdateTodoService(UpdateTodoRepository updateTodoRepository) {
        this.updateTodoRepository = updateTodoRepository;
    }

    public void execute(Todo todo) throws TodoNotFoundException {
        updateTodoRepository.execute(todo);
    }
}
