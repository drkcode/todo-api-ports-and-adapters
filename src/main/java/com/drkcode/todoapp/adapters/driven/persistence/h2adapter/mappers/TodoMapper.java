package com.drkcode.todoapp.adapters.driven.persistence.h2adapter.mappers;

import com.drkcode.todoapp.adapters.driven.persistence.h2adapter.entities.TodoEntity;
import com.drkcode.todoapp.adapters.driving.api.model.TodoDTO;
import com.drkcode.todoapp.domain.model.Todo;
import com.drkcode.todoapp.domain.model.TodoId;

public class TodoMapper {

    public static Todo toTodo(TodoEntity entity) {
        return new Todo(new TodoId(entity.getId()), entity.getContent());
    }

    public static TodoEntity toEntity(Todo todo) {
        return new TodoEntity(todo.getTodoId().getValue(), todo.getContent());
    }

    public static TodoDTO toDTO(Todo todo) {
        return new TodoDTO(todo.getTodoId().getValue(), todo.getContent());
    }
}
