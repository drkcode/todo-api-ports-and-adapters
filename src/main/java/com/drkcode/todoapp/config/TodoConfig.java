package com.drkcode.todoapp.config;

import com.drkcode.todoapp.adapters.driven.persistence.h2adapter.repositories.TodoRepositoryJPA;
import com.drkcode.todoapp.adapters.driven.persistence.h2adapter.repositories.impl.*;
import com.drkcode.todoapp.domain.services.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TodoConfig {

    private final TodoRepositoryJPA todoRepositoryJPA;

    public TodoConfig(TodoRepositoryJPA todoRepositoryJPA) {
        this.todoRepositoryJPA = todoRepositoryJPA;
    }

    @Bean
    public CreateTodoService create() {
        CreateTodoRepositoryImpl createTodoRepository = new CreateTodoRepositoryImpl(todoRepositoryJPA);
        return new CreateTodoService(createTodoRepository);
    }

    @Bean
    public GetTodosService getAll() {
        GetTodosRepositoryImpl getTodosRepository = new GetTodosRepositoryImpl(todoRepositoryJPA);
        return new GetTodosService(getTodosRepository);
    }

    @Bean
    public GetTodoByIdService getById() {
        GetTodoByIdRepositoryImpl getTodoByIdRepository = new GetTodoByIdRepositoryImpl(todoRepositoryJPA);
        return new GetTodoByIdService(getTodoByIdRepository);
    }

    @Bean
    public UpdateTodoService update() {
        UpdateTodoRepositoryImpl updateTodoRepository = new UpdateTodoRepositoryImpl(todoRepositoryJPA);
        return new UpdateTodoService(updateTodoRepository);
    }

    @Bean
    public DeleteTodoService delete() {
        DeleteTodoRepositoryImpl deleteTodoRepository = new DeleteTodoRepositoryImpl(todoRepositoryJPA);
        return new DeleteTodoService(deleteTodoRepository);
    }

}
