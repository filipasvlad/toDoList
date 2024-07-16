package com.example.todolist.api;

import com.example.todolist.entity.Task;
import com.example.todolist.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/tasks")
public class TaskRestController {
    private final TaskService taskService;

    public TaskRestController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<Task> getTasks(){
        return taskService.getTasks();
    }

    @PostMapping
    public void createTask(@RequestBody String taskDescription){
        taskService.createTask(taskDescription);
    }

    @PutMapping(path = "{id}")
    public void updateTask(@PathVariable Long id, @RequestBody String taskDescription){
        taskService.updateTask(id, taskDescription);
    }

    @DeleteMapping(path = "{id}")
    public void deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
    }
}
