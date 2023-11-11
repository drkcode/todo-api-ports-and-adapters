package com.drkcode.todoapp.domain.repositories;

import com.drkcode.todoapp.domain.model.Todo;

public interface UpdateTodoRepository {
    void execute(Todo todo);
}
