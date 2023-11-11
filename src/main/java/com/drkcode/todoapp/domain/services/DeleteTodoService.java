package com.drkcode.todoapp.domain.services;

import com.drkcode.todoapp.domain.model.TodoId;
import com.drkcode.todoapp.domain.repositories.DeleteTodoRepository;

public class DeleteTodoService {

    private final DeleteTodoRepository repository;

    public DeleteTodoService(DeleteTodoRepository repository) {
        this.repository = repository;
    }

    public void execute(TodoId todoId) {
        repository.execute(todoId);
    }
}
