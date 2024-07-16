package com.example.todolist.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @SequenceGenerator(
            name="employee_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "employee_sequence",
            strategy = GenerationType.SEQUENCE
    )
    private Long id;
    private String taskDescription;
    private String status;
    private String date;

    public Task(String taskDescription, String status, String date) {
        this.taskDescription = taskDescription;
        this.status = status;
        this.date = date;
    }

    public Task() {

    }

    public Long getId() {
        return id;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
