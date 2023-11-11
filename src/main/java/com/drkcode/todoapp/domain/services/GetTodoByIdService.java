package com.drkcode.todoapp.domain.services;

import com.drkcode.todoapp.domain.exceptions.TodoNotFoundException;
import com.drkcode.todoapp.domain.model.Todo;
import com.drkcode.todoapp.domain.model.TodoId;
import com.drkcode.todoapp.domain.repositories.GetTodoByIdRepository;

import java.util.Optional;

public class GetTodoByIdService {

    private final GetTodoByIdRepository getTodoByIdRepository;

    public GetTodoByIdService(GetTodoByIdRepository getTodoByIdRepository) {
        this.getTodoByIdRepository = getTodoByIdRepository;
    }

    public Todo execute(TodoId todoId) throws TodoNotFoundException {
        Optional<Todo> todo = getTodoByIdRepository.execute(todoId);
        if (todo.isEmpty()) throw new TodoNotFoundException("Todo Not Found");
        return todo.get();
    }

}
