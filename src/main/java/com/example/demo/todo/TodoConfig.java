package com.example.demo.todo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class TodoConfig {

    @Bean
    CommandLineRunner commandLineRunner(
            TodoRepository todoRepository
    ) {
        return args -> {
            Todo todo1 = new Todo("Learn Java");
            Todo todo2 = new Todo("Learn AWS");
            Todo todo3 = new Todo("Learn Docker");

            todoRepository.saveAll(List.of(todo1, todo2, todo3));
        };
    }
}
