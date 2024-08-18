package org.example.clickup.controller;

import org.example.clickup.dto.CategoryUserDto;
import org.example.clickup.model.CategoryUser;
import org.example.clickup.model.Result;
import org.example.clickup.service.CategoryUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoryuser")
public class CategoryUserController {
    @Autowired
    private CategoryUserService categoryUserService;
    @GetMapping
    public List<CategoryUser> getAllCategoryUsers() {
        return categoryUserService.getAllCategoryUsers();
    }

    @GetMapping("/{id}")
    public CategoryUser findCategoryUserById(@PathVariable Integer id) {
        return categoryUserService.getCategoryUserById(id);
    }
    @PostMapping
    public Result createCategoryUser(@RequestBody CategoryUserDto categoryUserDto) {
        return categoryUserService.createCategoryUser(categoryUserDto);
    }

    @PutMapping("/{id}")
    public Result updateCategoryUser(@PathVariable Integer id, @RequestBody CategoryUserDto categoryUserDto) {
        return categoryUserService.updateCategoryUser(id, categoryUserDto);
    }

    @DeleteMapping("/{id}")
    public Result deleteCategoryUser(@PathVariable Integer id) {
        return categoryUserService.deleteCategoryUser(id);
    }
}
