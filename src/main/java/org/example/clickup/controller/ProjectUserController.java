package org.example.clickup.controller;

import org.example.clickup.dto.ProjectUserDto;
import org.example.clickup.model.ProjectUser;
import org.example.clickup.model.Result;
import org.example.clickup.service.ProjectUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project-users")
public class ProjectUserController {
    @Autowired
    ProjectUserService projectUserService;

    @GetMapping
    public List<ProjectUser> getAllProjectUsers() {
        return projectUserService.getAllProjectUsers();
    }

    @GetMapping("/{id}")
    public ProjectUser findProjectUserById(@PathVariable Integer id) {
        return projectUserService.findById(id);
    }
    @PostMapping
    public Result createProjectUser(@RequestBody ProjectUserDto projectUserDto) {
        return projectUserService.createProjectUser(projectUserDto);
    }

    @PutMapping("/{id}")
    public Result updateProjectUser(@PathVariable Integer id, @RequestBody ProjectUserDto projectUserDto) {
        return projectUserService.updateProjectUser(id, projectUserDto);
    }

    @DeleteMapping("/{id}")
    public Result deleteProjectUser(@PathVariable Integer id) {
        return projectUserService.deleteProjectUser(id);
    }
}
