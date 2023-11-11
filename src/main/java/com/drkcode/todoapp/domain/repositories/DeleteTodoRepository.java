package com.drkcode.todoapp.domain.repositories;

import com.drkcode.todoapp.domain.model.TodoId;

public interface DeleteTodoRepository {
    void execute(TodoId todoId);
}
