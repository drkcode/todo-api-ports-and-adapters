package com.drkcode.todoapp.domain.repositories;

import com.drkcode.todoapp.domain.model.Todo;

import java.util.List;

public interface GetTodosRepository {

    List<Todo> execute();
}
