package com.shopsphere.novaflow;

import com.shopsphere.novaflow.entity.Task;
import com.shopsphere.novaflow.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    private final TaskService taskService;

    public HomeController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("tasks", taskService.getAllTasks());
        return "dashboard";
    }
    @GetMapping("/catalog")
    public String catalog() {
        return "catalog";
    }
    @GetMapping("/product")
    public String product() {
        return "product";
    }
    @GetMapping("/track-order")
    public String trackOrder() {
        return "track-order";
    }
    @GetMapping("/cart")
    public String cart() {
        return "cart";
    }
    @GetMapping("/checkout")
    public String checkout() {
        return "checkout";
    }


    @PostMapping("/add-task")
    public String addTask(@RequestParam String name) {

        Task task = new Task();
        task.setName(name);
        task.setStatus("Pending");

        taskService.saveTask(task);

        return "redirect:/dashboard";
    }

    @GetMapping("/delete-task/{id}")
    public String deleteTask(@PathVariable Long id) {

        taskService.deleteTask(id);

        return "redirect:/dashboard";
    }

    @GetMapping("/complete-task/{id}")
    public String completeTask(@PathVariable Long id) {

        taskService.completeTask(id);

        return "redirect:/dashboard";
    }
}

