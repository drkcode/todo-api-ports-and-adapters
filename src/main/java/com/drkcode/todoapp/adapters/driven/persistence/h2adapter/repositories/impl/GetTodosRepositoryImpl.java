package com.drkcode.todoapp.adapters.driven.persistence.h2adapter.repositories.impl;

import com.drkcode.todoapp.adapters.driven.persistence.h2adapter.mappers.TodoMapper;
import com.drkcode.todoapp.adapters.driven.persistence.h2adapter.repositories.TodoRepositoryJPA;
import com.drkcode.todoapp.domain.model.Todo;
import com.drkcode.todoapp.domain.repositories.GetTodosRepository;

import java.util.ArrayList;
import java.util.List;

public class GetTodosRepositoryImpl implements GetTodosRepository {

    private final TodoRepositoryJPA todoRepositoryJPA;

    public GetTodosRepositoryImpl(TodoRepositoryJPA todoRepositoryJPA) {
        this.todoRepositoryJPA = todoRepositoryJPA;
    }

    @Override
    public List<Todo> execute() {
        List<Todo> todos = new ArrayList<>();
        todoRepositoryJPA.findAll().forEach(entity -> {
            todos.add(TodoMapper.toTodo(entity));
        });

        return todos;
    }
}
