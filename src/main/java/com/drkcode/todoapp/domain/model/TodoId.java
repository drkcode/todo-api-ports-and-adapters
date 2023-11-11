package com.drkcode.todoapp.domain.model;

public class TodoId {
    private final String value;

    public TodoId(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "{" +
                "id='" + value + '\'' +
                '}';
    }
}
