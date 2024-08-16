package org.example.clickup.service;

import org.example.clickup.dto.CategoryDto;
import org.example.clickup.model.Category;
import org.example.clickup.model.Project;
import org.example.clickup.model.Result;
import org.example.clickup.repository.CategoryRepository;
import org.example.clickup.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    ProjectRepository projectRepository;

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Optional<Category> getCategoryById(Integer id) {
        return categoryRepository.findById(id);
    }

    public Result createCategory(CategoryDto categoryDto) {
        Optional<Project> project = projectRepository.findById(categoryDto.getProjectId());
        if (project.isPresent()) {
            Category category = new Category();
            category.setName(categoryDto.getName());
            category.setProjectId(project.get());
            category.setAccessType(categoryDto.getAccessType());
            category.setArchived(categoryDto.getArchived());
            category.setColor(categoryDto.getColor());
            categoryRepository.save(category);
            return new Result(true, "Category created successfully");
        }
        return new Result(false, "Project not found");
    }

    public Result updateCategory(Integer id, CategoryDto categoryDto) {
        Optional<Category> existingCategory = categoryRepository.findById(id);
        if (existingCategory.isPresent()) {
            Category category = existingCategory.get();
            Optional<Project> project = projectRepository.findById(categoryDto.getProjectId());
            if (project.isPresent()) {
                category.setName(categoryDto.getName());
                category.setProjectId(project.get());
                category.setAccessType(categoryDto.getAccessType());
                category.setArchived(categoryDto.getArchived());
                category.setColor(categoryDto.getColor());
                categoryRepository.save(category);
                return new Result(true, "Category updated successfully");
            }
            return new Result(false, "Project not found");
        }
        return new Result(false, "Category not found");
    }

    public Result deleteCategory(Integer id) {
        Optional<Category> existingCategory = categoryRepository.findById(id);
        if (existingCategory.isPresent()) {
            categoryRepository.delete(existingCategory.get());
            return new Result(true, "Category deleted successfully");
        }
        return new Result(false, "Category not found");
    }


}
