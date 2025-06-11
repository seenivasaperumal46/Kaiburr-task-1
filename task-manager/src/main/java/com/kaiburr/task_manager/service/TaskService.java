package com.kaiburr.task_manager.service;



import com.kaiburr.task_manager.model.Task;
import com.kaiburr.task_manager.model.TaskExecution;
import com.kaiburr.task_manager.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

@Service
public class TaskService {

    @Autowired
    private TaskRepository repository;

    public List<Task> getAllTasks() {
        return repository.findAll();
    }

    public Optional<Task> getTaskById(String id) {
        return repository.findById(id);
    }

    public Task createTask(Task task) {
        return repository.save(task);
    }

    public void deleteTask(String id) {
        repository.deleteById(id);
    }

    public List<Task> searchByName(String name) {
        return repository.findByNameContainingIgnoreCase(name);
    }

    public Task executeTask(String id) throws Exception {
        Task task = repository.findById(id).orElseThrow();

        Date startTime = new Date();
        ProcessBuilder builder = new ProcessBuilder("cmd", "/c", task.getCommand());
        Process process = builder.start();

        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        StringBuilder output = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            output.append(line).append("\n");
        }

        process.waitFor();
        Date endTime = new Date();

        TaskExecution execution = new TaskExecution(startTime, endTime, output.toString());
        List<TaskExecution> executions = task.getTaskExecutions();
        if (executions == null) executions = new ArrayList<>();
        executions.add(execution);
        task.setTaskExecutions(executions);

        return repository.save(task);
    }

}


