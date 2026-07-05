package com.shopsphere.novaflow.service;

import com.shopsphere.novaflow.entity.Task;
import com.shopsphere.novaflow.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    public void completeTask(Long id) {

        Task task = taskRepository.findById(id).orElse(null);

        if (task != null) {
            task.setStatus("Completed");
            taskRepository.save(task);
        }
    }
}

