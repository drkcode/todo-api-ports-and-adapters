package com.drkcode.todoapp.adapters.driven.persistence.h2adapter.repositories.impl;

import com.drkcode.todoapp.adapters.driven.persistence.h2adapter.repositories.TodoRepositoryJPA;
import com.drkcode.todoapp.domain.model.TodoId;
import com.drkcode.todoapp.domain.repositories.DeleteTodoRepository;

public class DeleteTodoRepositoryImpl implements DeleteTodoRepository {

    private final TodoRepositoryJPA todoRepositoryJPA;

    public DeleteTodoRepositoryImpl(TodoRepositoryJPA todoRepositoryJPA) {
        this.todoRepositoryJPA = todoRepositoryJPA;
    }

    @Override
    public void execute(TodoId todoId) {
        todoRepositoryJPA.deleteById(todoId.getValue());
    }
}
