package com.example.demo.todo;

import javax.persistence.*;

@Entity
@Table
public class Todo {
    @Id
    @SequenceGenerator(
            name = "todo_sequence",
            sequenceName = "todo_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "todo_sequence"
    )
    private Long id;
    private String description;
    private Enum<TODO_STATUS> status;

    public enum TODO_STATUS {
        DONE,
        DOING
    }

    public Todo(String description) {
        this.description = description;
        this.status = TODO_STATUS.DOING;
    }

    public Todo(Long id, String description) {
        this.id = id;
        this.description = description;
        this.status = TODO_STATUS.DOING;
    }

    public Todo() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(Enum<TODO_STATUS> status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public Enum<TODO_STATUS> getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", status=" + status +
                '}';
    }
}
