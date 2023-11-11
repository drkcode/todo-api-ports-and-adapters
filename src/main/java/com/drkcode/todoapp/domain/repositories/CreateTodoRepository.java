package com.drkcode.todoapp.domain.repositories;

import com.drkcode.todoapp.domain.model.Todo;
import com.drkcode.todoapp.domain.model.TodoId;

public interface CreateTodoRepository {
    TodoId execute(Todo todo);
}
