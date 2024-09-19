package com.kellyprojects.ob_hibernate_project.controller;

import com.kellyprojects.ob_hibernate_project.entities.Task;
import com.kellyprojects.ob_hibernate_project.entities.User;
import com.kellyprojects.ob_hibernate_project.repository.TaskRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/api/tasks")
public class TaskController {
    private TaskRepository taskRepository;
    public TaskController(TaskRepository taskRepository){
        this.taskRepository=taskRepository;
    }

    @GetMapping("api/tasks")
    private List<Task> findAll(){
        return  this.taskRepository.findAll();
    }
    @PostMapping("/api/tasks")
    private Task create(@RequestBody Task task){
        return this.taskRepository.save(task);
    }

    @PutMapping("/api/tasks")
    private Task update(@RequestBody Task task){
        return this.taskRepository.save(task);
    }

    @DeleteMapping("api/tasks/{id}")
    private void delete (@PathVariable Long id){
        if (this.taskRepository.existsById(id)){
            this.taskRepository.deleteById(id);
        }

    }
}
