package com.drkcode.todoapp.domain.repositories;

import com.drkcode.todoapp.domain.model.Todo;
import com.drkcode.todoapp.domain.model.TodoId;

import java.util.Optional;

public interface GetTodoByIdRepository {
    Optional<Todo> execute(TodoId todoId);
}
