package com.drkcode.todoapp.adapters.driven.persistence.h2adapter.repositories;

import com.drkcode.todoapp.adapters.driven.persistence.h2adapter.TodoRepositoryJPA;
import com.drkcode.todoapp.adapters.driven.persistence.h2adapter.mappers.TodoMapper;
import com.drkcode.todoapp.domain.model.Todo;
import com.drkcode.todoapp.domain.repositories.UpdateTodoRepository;

public class UpdateTodoPersistence implements UpdateTodoRepository {
    private final TodoRepositoryJPA todoRepositoryJPA;

    public UpdateTodoPersistence(TodoRepositoryJPA todoRepositoryJPA) {
        this.todoRepositoryJPA = todoRepositoryJPA;
    }

    @Override
    public void execute(Todo todo) {
        todoRepositoryJPA.save(TodoMapper.toEntity(todo));
    }
}
