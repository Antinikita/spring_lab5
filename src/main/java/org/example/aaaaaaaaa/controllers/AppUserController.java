package org.example.aaaaaaaaa.controllers;

import org.example.aaaaaaaaa.models.AppUser;
import org.example.aaaaaaaaa.models.Tasks;
import org.example.aaaaaaaaa.repository.AppUserRepository;
import org.example.aaaaaaaaa.repository.TasksRepository;
import org.example.aaaaaaaaa.security.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class AppUserController {
    private final AppUserService appUserService;
    AppUserRepository appUserRepository;
    private final TasksRepository tasksRepository;
    public AppUserController(final AppUserService appUserService, final AppUserRepository appUserRepository, final TasksRepository tasksRepository) {
        this.appUserService = appUserService;
        this.tasksRepository=tasksRepository;
        this.appUserRepository = appUserRepository;
    }
    @GetMapping("/login")
    public String login() {
        return "login";
    }
    @GetMapping("/register")
    public String register() {
        return "register";
    }
    @PostMapping("/register")
    public String register(@RequestParam String username, @RequestParam String password) {
        appUserService.registerAppUser(username, password);
        return "redirect:/login";
    }
    @GetMapping("/home")
    public String home() {
        return "home";
    }

}

