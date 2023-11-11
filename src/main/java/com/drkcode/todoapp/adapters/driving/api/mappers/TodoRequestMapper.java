package com.drkcode.todoapp.adapters.driving.api.mappers;

import com.drkcode.todoapp.adapters.driving.api.model.CreateTodoRequest;
import com.drkcode.todoapp.adapters.driving.api.model.TodoDTO;
import com.drkcode.todoapp.adapters.driving.api.model.UpdateTodoRequest;
import com.drkcode.todoapp.domain.model.Todo;
import com.drkcode.todoapp.domain.model.TodoId;

import java.util.List;
import java.util.stream.Collectors;

public class TodoRequestMapper {

    public static Todo toTodo(UpdateTodoRequest request) {
        return new Todo(new TodoId(request.todoId()), request.content());
    }

    public static Todo toTodo(CreateTodoRequest request) {
        return new Todo(null, request.content());
    }

    public static List<TodoDTO> toDTO(List<Todo> todos) {
        return todos.stream().map(todo -> new TodoDTO(todo.getTodoId().getValue(), todo.getContent()))
                .collect(Collectors.toList());
    }

    public static TodoDTO toDTO(Todo todo) {
        return new TodoDTO(todo.getTodoId().getValue(), todo.getContent());
    }


}
