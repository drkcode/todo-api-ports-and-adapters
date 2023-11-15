package com.drkcode.todoapp.adapters.driven.persistence.h2adapter.repositories;

import com.drkcode.todoapp.adapters.driven.persistence.h2adapter.entities.TodoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepositoryJPA extends CrudRepository<TodoEntity, String> {
}
