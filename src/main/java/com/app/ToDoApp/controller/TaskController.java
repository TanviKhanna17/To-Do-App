package com.app.ToDoApp.controller;


import com.app.ToDoApp.models.Task;
import com.app.ToDoApp.services.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//Tells Spring Boot that this class will handle web requests.
//It is part of the MVC (Model-View-Controller) pattern, where:
// Model stores data
// View (HTML page) displays data
// Controller handles user requests and processes responses.

@Controller // MARKS CLASS AS SPRING MVC CONTROLLER, CLASS THAT HANDLES HTTP REQUESTS AND DEFINES ENDPOINTS FOR YOUR APPLICATION, ACTS AS BRIDGE BETWEEN USER AND LOGIC
//@RequestMapping("/tasks") // Sets a base URL for all endpoints in this controller.
public class TaskController
{
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping // MAPS THIS METHOD TO GET REQUESTS
    public String getTask(Model model)
    {
        List<Task> tasks = taskService.getAllTasks();
        model.addAttribute("tasks",tasks);
        return "tasks"; // this will look out for tasks.html under resources // name of the view which will be picked up
    }

    @PostMapping // MAPS THIS METHOD TO GET REQUESTS
    public String createTask(@RequestParam String title)
    {
        taskService.createTask(title);
        return "redirect:/"; // this will look out for tasks.html under resources // name of the view which will be picked up
    }

    @GetMapping("/{id}/delete") // we need id for task to be deleted, id passed here will enter in the param below
    public String deleteTask(@PathVariable Long id)
    {
        taskService.deleteTask(id);
        return "redirect:/"; // this will look out for tasks.html under resources // name of the view which will be picked up
    }

    @GetMapping("/{id}/toggle") // we need id for task to be deleted, id passed here will enter in the param below
    public String toggleTask(@PathVariable Long id)
    {
        taskService.toggleTask(id);
        return "redirect:/"; // this will look out for tasks.html under resources // name of the view which will be picked up
    }





}
