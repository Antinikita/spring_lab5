package org.example.aaaaaaaaa.service;

import org.example.aaaaaaaaa.models.AppUser;
import org.example.aaaaaaaaa.models.Categories;
import org.example.aaaaaaaaa.models.Tasks;
import org.example.aaaaaaaaa.repository.AppUserRepository;
import org.example.aaaaaaaaa.repository.CategoriesRepository;
import org.example.aaaaaaaaa.repository.TasksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    TasksRepository tasksRepository;
    @Autowired
    AppUserRepository appUserRepository;
    @Autowired
    CategoriesRepository categoriesRepository;

    public List<Tasks> getTasksByUser(String username) {
        AppUser user=appUserRepository.findByUsername(username).orElseThrow(()->new RuntimeException("User not found"));
        return tasksRepository.findByAppUser(user);
    }
    public Tasks addTask( String username,Tasks task, Long categoryId) {
        AppUser user=appUserRepository.findByUsername(username).orElseThrow(()->new RuntimeException("User not found"));
        task.setAppUser(user);
        if (categoryId != null) {
            Categories category = categoriesRepository.findById(categoryId).orElseThrow(() -> new RuntimeException("Category not found"));
            task.setCategory(category);
        }
        return tasksRepository.save(task);
    }
    public List<Categories> getCategories() {
        return categoriesRepository.findAll();
    }
}
