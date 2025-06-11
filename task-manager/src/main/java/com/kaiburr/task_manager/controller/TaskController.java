package com.kaiburr.task_manager.controller;



import com.kaiburr.task_manager.model.Task;
import com.kaiburr.task_manager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService service;

    @GetMapping
    public ResponseEntity<?> getTasks(@RequestParam(required = false) String id) {
        if (id != null) {
            return service.getTaskById(id)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        }
        return ResponseEntity.ok(service.getAllTasks());
    }

    @PutMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        return ResponseEntity.ok(service.createTask(task));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable String id) {
        service.deleteTask(id);
        return ResponseEntity.ok("Task deleted");
    }

    @GetMapping("/search")
    public ResponseEntity<List<Task>> searchByName(@RequestParam String name) {
        List<Task> tasks = service.searchByName(name);
        if (tasks.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(tasks);
    }

    @PutMapping("/{id}/run")
    public ResponseEntity<Task> runTask(@PathVariable String id) {
        try {
            return ResponseEntity.ok(service.executeTask(id));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(null);
        }
    }


}

