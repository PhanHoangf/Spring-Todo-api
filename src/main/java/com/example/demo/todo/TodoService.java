package com.example.demo.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodoService {
    private final TodoRepository todoRepository;

    @Autowired
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> getToDos() {
        return todoRepository.findAll();
    }

    public void addNewTodo(Todo todo) {
        todoRepository.save(todo);
    }

    @Transactional
    public void updateTodoStatus(Long id) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Todo with id: " + id + " does not exists"));

        if (todo.getStatus() == Todo.TODO_STATUS.DOING) {
            todo.setStatus(Todo.TODO_STATUS.DONE);
        } else todo.setStatus(Todo.TODO_STATUS.DOING);
    }

    public void deleteTodo(Long id) {
        boolean exists = todoRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException(
                    "Todo with id: " + id + " does not exists"
            );
        }
        todoRepository.deleteById(id);
    }

    public List<Todo> getDoingTodos() {
        return todoRepository.findAll().stream().filter(
                todo -> todo.getStatus().equals(Todo.TODO_STATUS.DOING)
        ).collect(Collectors.toList());
    }

    public List<Todo> getDoneTodos() {
        return todoRepository.findAll().stream().filter(
                todo -> todo.getStatus().equals(Todo.TODO_STATUS.DONE)
        ).collect(Collectors.toList());
    }
}
