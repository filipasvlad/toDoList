package com.example.todolist.web;

import com.example.todolist.entity.Task;
import com.example.todolist.service.TaskService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "tasks")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        super();
        this.taskService = taskService;
    }

    @GetMapping
    public String getTasks(Model model){
        model.addAttribute("tasks", taskService.getTasks());
        return "tasks";
    }

    @PostMapping
    public String createTask(@ModelAttribute("taskDescription") String taskDescription){
        taskService.createTask(taskDescription);
        return "redirect:/tasks";
    }

    @GetMapping(path = "/delete/{id}")
    public String deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
        return "redirect:/tasks";
    }

    @GetMapping(path = "/edit/{id}")
    public String editTaskForm(@PathVariable Long id, Model model){
        model.addAttribute("task", taskService.getTaskById(id));
        return "update_task";
    }

    @GetMapping(path = "/create")
    public String createTaskForm(){
        return "create_task";
    }

    @PostMapping(path = "{id}")
    public String editTask(@PathVariable Long id, @ModelAttribute("taskDescription") String taskDescription){
        taskService.updateTask(id, taskDescription);
        return "redirect:/tasks";
    }

    @GetMapping(path = "/complete/{id}")
    public String makeTeakCompleted(@PathVariable Long id){
        taskService.makeTaskCompleted(id);
        return "redirect:/tasks";
    }
}
