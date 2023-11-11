package com.drkcode.todoapp.adapters.driven.persistence.h2adapter.repositories;

import com.drkcode.todoapp.adapters.driven.persistence.h2adapter.TodoRepositoryJPA;
import com.drkcode.todoapp.domain.model.TodoId;
import com.drkcode.todoapp.domain.repositories.DeleteTodoRepository;

public class DeleteTodoPersistence implements DeleteTodoRepository {

    private final TodoRepositoryJPA todoRepositoryJPA;

    public DeleteTodoPersistence(TodoRepositoryJPA todoRepositoryJPA) {
        this.todoRepositoryJPA = todoRepositoryJPA;
    }

    @Override
    public void execute(TodoId todoId) {
        todoRepositoryJPA.deleteById(todoId.getValue());
    }
}
