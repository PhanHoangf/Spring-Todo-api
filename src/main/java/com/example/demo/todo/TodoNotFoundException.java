package com.example.demo.todo;

public class TodoNotFoundException extends RuntimeException {
    TodoNotFoundException(Long id) {
        super("Could not found todo " + id);
    }
}
