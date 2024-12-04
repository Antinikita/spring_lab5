package org.example.aaaaaaaaa.controllers;

import org.example.aaaaaaaaa.models.AppUser;
import org.example.aaaaaaaaa.models.Tasks;
import org.example.aaaaaaaaa.repository.AppUserRepository;
import org.example.aaaaaaaaa.repository.CategoriesRepository;
import org.example.aaaaaaaaa.repository.TasksRepository;
import org.example.aaaaaaaaa.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.Task;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;
    private final AppUserRepository appUserRepository;
    TasksRepository tasksRepository;
    CategoriesRepository categoriesRepository;

    public TaskController(TaskService taskService, AppUserRepository appUserRepository) {
        this.taskService = taskService;
        this.appUserRepository = appUserRepository;
    }

    @GetMapping
    public String getTasks(@AuthenticationPrincipal UserDetails userDetails, Model model) {
        String username = userDetails.getUsername();
        model.addAttribute("tasks",taskService.getTasksByUser(username));
        return "tasks";
    }

    @GetMapping("/add")
    public String showAddTaskForm(Model model) {
        model.addAttribute("task", new Tasks());
        model.addAttribute("categories", taskService.getCategories());
        return "add_task";

    }
    @PostMapping("/add")
    public String addTask(@AuthenticationPrincipal UserDetails userDetails, @ModelAttribute Tasks task, @RequestParam(required = false) Long categoryId) {
        taskService.addTask(userDetails.getUsername(), task,categoryId);
        return "redirect:/home";
    }


}
