package com.drkcode.todoapp.config;

import com.drkcode.todoapp.adapters.driven.persistence.h2adapter.TodoRepositoryJPA;
import com.drkcode.todoapp.adapters.driven.persistence.h2adapter.repositories.*;
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
    public CreateTodoService createTodo() {
        CreateTodoPersistence createTodoPersistence = new CreateTodoPersistence(todoRepositoryJPA);
        return new CreateTodoService(createTodoPersistence);
    }

    @Bean
    public GetTodosService getTodosService() {
        GetTodosPersistence getTodosPersistence = new GetTodosPersistence(todoRepositoryJPA);
        return new GetTodosService(getTodosPersistence);
    }

    @Bean
    public GetTodoByIdService getTodoByIdService() {
        GetTodoByIdPersistence getTodoByIdPersistence = new GetTodoByIdPersistence(todoRepositoryJPA);
        return new GetTodoByIdService(getTodoByIdPersistence);
    }

    @Bean
    public UpdateTodoService updateTodoService() {
        UpdateTodoPersistence updateTodoPersistence = new UpdateTodoPersistence(todoRepositoryJPA);
        return new UpdateTodoService(updateTodoPersistence);
    }

    @Bean
    public DeleteTodoService deleteTodoService() {
        DeleteTodoPersistence deleteTodoPersistence = new DeleteTodoPersistence(todoRepositoryJPA);
        return new DeleteTodoService(deleteTodoPersistence);
    }

}
