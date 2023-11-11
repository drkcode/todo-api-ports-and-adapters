package com.drkcode.todoapp.adapters.driven.persistence.h2adapter.repositories;

import com.drkcode.todoapp.adapters.driven.persistence.h2adapter.TodoRepositoryJPA;
import com.drkcode.todoapp.adapters.driven.persistence.h2adapter.mappers.TodoMapper;
import com.drkcode.todoapp.domain.model.Todo;
import com.drkcode.todoapp.domain.model.TodoId;
import com.drkcode.todoapp.domain.repositories.CreateTodoRepository;

public class CreateTodoPersistence implements CreateTodoRepository {

    private final TodoRepositoryJPA todoRepositoryJPA;

    public CreateTodoPersistence(TodoRepositoryJPA todoRepositoryJPA) {
        this.todoRepositoryJPA = todoRepositoryJPA;
    }

    @Override
    public TodoId execute(Todo todo) {
        todoRepositoryJPA.save(TodoMapper.toEntity(todo));
        return todo.getTodoId();
    }
}
