package org.example.clickup.controller;

import org.example.clickup.dto.ProjectDto;
import org.example.clickup.model.Project;
import org.example.clickup.model.Result;
import org.example.clickup.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/project")
public class ProjectController {
    @Autowired
    ProjectService projectService;

    @GetMapping
    public List<Project> getAllProjects() {
        return projectService.getAllProjects();
    }

    @GetMapping("/{id}")
    public Project getProjectById(@PathVariable Integer id) {
        return projectService.getProjectById(id);
    }

    @PostMapping
    public Result createProject(@RequestBody ProjectDto projectDto) {
        return projectService.createProject(projectDto);
    }

    @PutMapping("/{id}")
    public Result updateProject(@PathVariable Integer id, @RequestBody ProjectDto projectDto) {
        return projectService.updateProject(id, projectDto);
    }

    @DeleteMapping("/{id}")
    public Result deleteProject(@PathVariable Integer id) {
        return projectService.deleteProject(id);
    }


}
