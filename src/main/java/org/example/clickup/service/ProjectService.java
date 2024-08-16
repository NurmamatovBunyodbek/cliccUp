package org.example.clickup.service;

import org.example.clickup.dto.ProjectDto;
import org.example.clickup.model.Project;
import org.example.clickup.model.Result;
import org.example.clickup.model.Space;
import org.example.clickup.repository.ProjectRepository;
import org.example.clickup.repository.SpaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {
    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    SpaceRepository spaceRepository;

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public Project getProjectById(Integer id) {
        Optional<Project> byId = projectRepository.findById(id);
        return byId.get();
    }

    public Result createProject(ProjectDto projectDto) {
        boolean existsedByName = projectRepository.existsByName(projectDto.getName());
        if (existsedByName) {
            return new Result(false, "Bunday nomli project mavjud");
        }
        Optional<Space> space = spaceRepository.findById(projectDto.getSpaceId());
        Project project = new Project();
        project.setName(projectDto.getName());
        project.setSpaceID(space.get());
        project.setAccessType(projectDto.getAccessType());
        project.setArchived(projectDto.getArchived());
        project.setColor(projectDto.getColor());
        projectRepository.save(project);
        return new Result(true, "Project created successfully");

    }

    public Result updateProject(Integer id, ProjectDto projectDto) {
        Optional<Project> updatedProject = projectRepository.findById(id);
        if (updatedProject.isPresent()) {
            Project project = updatedProject.get();
            Optional<Space> space = spaceRepository.findById(projectDto.getSpaceId());

                project.setName(projectDto.getName());
                project.setSpaceID(space.get());
                project.setAccessType(projectDto.getAccessType());
                project.setArchived(projectDto.getArchived());
                project.setColor(projectDto.getColor());
                projectRepository.save(project);
                return new Result(true, "Project updated successfully");
            }
        return new Result(false, "Project not found");
    }

    public Result deleteProject(Integer id) {
        projectRepository.deleteById(id);
        return new Result(true, "Project deleted successfully");
    }

}
