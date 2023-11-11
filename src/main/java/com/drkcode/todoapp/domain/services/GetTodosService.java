package com.drkcode.todoapp.domain.services;

import com.drkcode.todoapp.domain.model.Todo;
import com.drkcode.todoapp.domain.repositories.GetTodosRepository;

import java.util.List;

public class GetTodosService {

    private final GetTodosRepository getTodosRepository;

    public GetTodosService(GetTodosRepository getTodosRepository) {
        this.getTodosRepository = getTodosRepository;
    }

    public List<Todo> execute() {
        return getTodosRepository.execute();
    }
}
