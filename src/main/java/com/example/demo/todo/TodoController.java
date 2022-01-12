package com.example.demo.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/todo")
public class TodoController {
    private final TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping(path = "doing")
    public List<Todo> getDoingTodos() {
        return todoService.getDoingTodos();
    }

    @GetMapping(path = "done")
    public List<Todo> getDoneTodos() {
        return todoService.getDoneTodos();
    }

    @GetMapping
    public List<Todo> getTodos() {
        return todoService.getToDos();
    }

    @PostMapping
    public void addNewTodo(
            @RequestBody Todo todo
    ) {
        Todo newTodo = new Todo(todo.getDescription());
        todoService.addNewTodo(newTodo);
    }

    @PutMapping(path = "{todoId}")
    public void updateTodo(
            @PathVariable("todoId") Long id
    ) {
        todoService.updateTodoStatus(id);
    }

    @DeleteMapping(path = "{todoId}")
    public void deleteTodo(
            @PathVariable("todoId") Long id
    ) {
        todoService.deleteTodo(id);
    }
}
