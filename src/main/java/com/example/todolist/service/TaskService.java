package com.example.todolist.service;

import com.example.todolist.entity.Task;
import com.example.todolist.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class TaskService implements ITaskService{
    private final TaskRepository taskRepository;


    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Task> getTasks() {
        return taskRepository.findAll();
    }

    @Override
    public void createTask(String taskDescription) {
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String todayDate = today.format(formatter);
        Task task = new Task(taskDescription, "Incomplete", todayDate);
        taskRepository.save(task);
    }

    @Override
    public void deleteTask(Long id) {
        if (!taskRepository.existsById(id)){
            throw new IllegalStateException(String.format("ID %s doesn't exist!", id));
        }
        taskRepository.deleteById(id);
    }

    @Override
    public void updateTask(Long id, String taskDescription) {
        Task taskToUpdate = taskRepository.findById(id).orElseThrow(
                () -> new IllegalStateException(String.format("ID %s doesn't exist!", id)));
        taskToUpdate.setTaskDescription(taskDescription);
        taskRepository.save(taskToUpdate);
    }



    @Override
    public Task getTaskById(Long id) {
        return taskRepository.findById(id).orElseThrow(
                () -> new IllegalStateException(String.format("ID %s doesn't exist!", id)));
    }

    @Override
    public void makeTaskCompleted(Long id) {
        Task taskToUpdate = taskRepository.findById(id).orElseThrow(
                () -> new IllegalStateException(String.format("ID %s doesn't exist!", id)));
        taskToUpdate.setStatus("Completed");
        taskRepository.save(taskToUpdate);
    }


}
