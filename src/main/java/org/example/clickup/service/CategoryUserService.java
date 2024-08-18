package org.example.clickup.service;

import org.example.clickup.dto.CategoryUserDto;
import org.example.clickup.model.Category;
import org.example.clickup.model.CategoryUser;
import org.example.clickup.model.Result;
import org.example.clickup.model.User;
import org.example.clickup.repository.CategoryRepository;
import org.example.clickup.repository.CategoryUserRepository;
import org.example.clickup.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryUserService {
    @Autowired
    CategoryUserRepository categoryUserRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    UserRepository userRepository;

    public List<CategoryUser> getAllCategoryUsers() {
        return categoryUserRepository.findAll();
    }

    public CategoryUser getCategoryUserById(Integer id) {
        Optional<CategoryUser> byId = categoryUserRepository.findById(id);
        return byId.get();
    }
    public Result createCategoryUser(CategoryUserDto categoryUserDto) {
        Optional<Category> categoryOptional = categoryRepository.findById(categoryUserDto.getCategoryid());
        Optional<User> userOptional = userRepository.findById(categoryUserDto.getUserid());
        CategoryUser categoryUser = new CategoryUser();
        categoryUser.setName(categoryUserDto.getName());
        categoryUser.setCategoryid(categoryOptional.get());
        categoryUser.setUserid(userOptional.get());
        categoryUserRepository.save(categoryUser);
        return new Result(true, "CategoryUser created successfully");
    }
    public Result updateCategoryUser(Integer id,CategoryUserDto categoryUserDto) {
        Optional<CategoryUser> categoryUserOptional = categoryUserRepository.findById(id);
        if (categoryUserOptional.isPresent()) {
            Optional<Category> categoryOptional = categoryRepository.findById(categoryUserDto.getCategoryid());
            Optional<User> userOptional = userRepository.findById(categoryUserDto.getUserid());
            CategoryUser categoryUser = categoryUserOptional.get();
            categoryUser.setName(categoryUserDto.getName());
            categoryUser.setCategoryid(categoryOptional.get());
            categoryUser.setUserid(userOptional.get());
            categoryUserRepository.save(categoryUser);
            return new Result(true, "CategoryUser updated successfully");
        }
        return new Result(false, "CategoryUser not found");
    }
    public Result deleteCategoryUser(Integer id) {
        Optional<CategoryUser> categoryUserOptional = categoryUserRepository.findById(id);
        if (categoryUserOptional.isPresent()) {
            categoryUserRepository.deleteById(id);
            return new Result(true, "CategoryUser deleted successfully");
        }
        return new Result(false, "CategoryUser not found");

    }


}
