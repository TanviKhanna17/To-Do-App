package com.app.ToDoApp.services;

import com.app.ToDoApp.models.Task;
import com.app.ToDoApp.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // PROCESSES BUSINESS LOGIC , IS INTERMEDIARY BETWEEN CONTROLLER AND DATABASE
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks() {
        // NOW WE'VE TO FETCH ALL QUERIES FROM DB, NO NEED OF QUERIES WE HAVE REPOSITORY TO DO THAT FOR US
        return taskRepository.findAll();
    }

    public void createTask(String title) {
        Task task = new Task();
        task.setTitle(title);
        task.setCompleted(false);
        taskRepository.save(task);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    public void toggleTask(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow( () -> new IllegalArgumentException("INVALID TASK ID"));
        task.setCompleted(!task.isCompleted());
        taskRepository.save(task);
    }
}
