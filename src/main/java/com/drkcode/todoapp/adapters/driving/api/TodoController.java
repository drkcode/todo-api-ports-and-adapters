package com.drkcode.todoapp.adapters.driving.api;

import com.drkcode.todoapp.adapters.driving.api.mappers.TodoRequestMapper;
import com.drkcode.todoapp.adapters.driving.api.model.CreateTodoRequest;
import com.drkcode.todoapp.adapters.driving.api.model.TodoDTO;
import com.drkcode.todoapp.adapters.driving.api.model.UpdateTodoRequest;
import com.drkcode.todoapp.domain.exceptions.TodoNotFoundException;
import com.drkcode.todoapp.domain.model.Todo;
import com.drkcode.todoapp.domain.model.TodoId;
import com.drkcode.todoapp.domain.services.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

    private final CreateTodoService createTodoService;
    private final GetTodosService getTodosService;
    private final GetTodoByIdService getTodoByIdService;
    private final UpdateTodoService updateTodoService;
    private final DeleteTodoService deleteTodoService;

    public TodoController(CreateTodoService createTodoService, GetTodosService getTodosService, GetTodoByIdService getTodoByIdService, UpdateTodoService updateTodoService, DeleteTodoService deleteTodoService) {
        this.createTodoService = createTodoService;
        this.getTodosService = getTodosService;
        this.getTodoByIdService = getTodoByIdService;
        this.updateTodoService = updateTodoService;
        this.deleteTodoService = deleteTodoService;
    }

    @PostMapping
    public ResponseEntity<TodoId> createTodo(@RequestBody CreateTodoRequest request) {
        var todoId = createTodoService.execute(TodoRequestMapper.toTodo(request));
        return ResponseEntity.created(URI.create("/" + todoId.getValue())).build();
    }

    @GetMapping
    public ResponseEntity<List<TodoDTO>> getTodos() {
        List<Todo> todos = getTodosService.execute();
        return ResponseEntity.ok(TodoRequestMapper.toDTO(todos));
    }

    @GetMapping("/{todoId}")
    public ResponseEntity<TodoDTO> getTodoById(@PathVariable String todoId) {
        try {
            Todo todo = getTodoByIdService.execute(new TodoId(todoId));
            return ResponseEntity.ok(TodoRequestMapper.toDTO(todo));
        } catch (TodoNotFoundException exception) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{todoId}")
    public ResponseEntity<?> updateTodo(@PathVariable String todoId, @RequestBody UpdateTodoRequest request) {
        try {
            getTodoByIdService.execute(new TodoId(todoId));
            updateTodoService.execute(TodoRequestMapper.toTodo(request));
            return ResponseEntity.noContent().build();
        } catch (TodoNotFoundException exception) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{todoId}")
    public ResponseEntity<?> deleteTodo(@PathVariable String todoId) {
        try {
            var todoIdVO = new TodoId(todoId);
            getTodoByIdService.execute(todoIdVO);
            deleteTodoService.execute(todoIdVO);
            return ResponseEntity.noContent().build();
        } catch (TodoNotFoundException exception) {
            return ResponseEntity.notFound().build();
        }
    }
}
