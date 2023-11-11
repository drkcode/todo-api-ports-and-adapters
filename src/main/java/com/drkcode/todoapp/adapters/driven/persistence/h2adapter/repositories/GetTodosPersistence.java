package com.drkcode.todoapp.adapters.driven.persistence.h2adapter.repositories;

import com.drkcode.todoapp.adapters.driven.persistence.h2adapter.TodoRepositoryJPA;
import com.drkcode.todoapp.adapters.driven.persistence.h2adapter.mappers.TodoMapper;
import com.drkcode.todoapp.domain.model.Todo;
import com.drkcode.todoapp.domain.repositories.GetTodosRepository;

import java.util.ArrayList;
import java.util.List;

public class GetTodosPersistence implements GetTodosRepository {

    private final TodoRepositoryJPA todoRepositoryJPA;

    public GetTodosPersistence(TodoRepositoryJPA todoRepositoryJPA) {
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
