package com.drkcode.todoapp.domain.model;

public class Todo {
    private final TodoId todoId;
    private final String content;

    public Todo(TodoId todoId, String content) {
        this.todoId = todoId;
        this.content = content;
    }

    public TodoId getTodoId() {
        return todoId;
    }

    public String getContent() {
        return content;
    }
}
