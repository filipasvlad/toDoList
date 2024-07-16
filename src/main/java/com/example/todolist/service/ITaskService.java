package com.example.todolist.service;

import com.example.todolist.entity.Task;

import java.util.List;

public interface ITaskService {
    List<Task> getTasks();
    void createTask(String taskDescription);

    void deleteTask(Long id);
    void updateTask(Long id, String taskDescription);
    Task getTaskById(Long id);

    void makeTaskCompleted(Long id);
}
