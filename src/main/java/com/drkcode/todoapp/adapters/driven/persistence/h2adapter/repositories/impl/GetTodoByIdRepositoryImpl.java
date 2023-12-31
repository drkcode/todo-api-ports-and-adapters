package com.drkcode.todoapp.adapters.driven.persistence.h2adapter.repositories.impl;

import com.drkcode.todoapp.adapters.driven.persistence.h2adapter.entities.TodoEntity;
import com.drkcode.todoapp.adapters.driven.persistence.h2adapter.mappers.TodoMapper;
import com.drkcode.todoapp.adapters.driven.persistence.h2adapter.repositories.TodoRepositoryJPA;
import com.drkcode.todoapp.domain.model.Todo;
import com.drkcode.todoapp.domain.model.TodoId;
import com.drkcode.todoapp.domain.repositories.GetTodoByIdRepository;

import java.util.Optional;

public class GetTodoByIdRepositoryImpl implements GetTodoByIdRepository {

    private final TodoRepositoryJPA todoRepositoryJPA;

    public GetTodoByIdRepositoryImpl(TodoRepositoryJPA todoRepositoryJPA) {
        this.todoRepositoryJPA = todoRepositoryJPA;
    }

    @Override
    public Optional<Todo> execute(TodoId todoId) {
        Optional<TodoEntity> todoEntity = todoRepositoryJPA.findById(todoId.getValue());
        return todoEntity.map(TodoMapper::toTodo);
    }
}
