package org.example.clickup.service;

import org.example.clickup.dto.ProjectUserDto;
import org.example.clickup.model.Project;
import org.example.clickup.model.ProjectUser;
import org.example.clickup.model.Result;
import org.example.clickup.model.User;
import org.example.clickup.repository.ProjectRepository;
import org.example.clickup.repository.ProjectUserRepository;
import org.example.clickup.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectUserService {
    @Autowired
    ProjectUserRepository projectUserRepository;

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    UserRepository userRepository;

    public List<ProjectUser> getAllProjectUsers() {
        return projectUserRepository.findAll();
    }

    public ProjectUser findById(Integer id) {
        Optional<ProjectUser> projectUser = projectUserRepository.findById(id);
        return projectUser.get();

    }

    public Result createProjectUser(ProjectUserDto projectUserDto) {
        Optional<Project> project = projectRepository.findById(projectUserDto.getProjectId());
        Optional<User> user = userRepository.findById(projectUserDto.getUserId());
        ProjectUser projectUser = new ProjectUser();
        projectUser.setProjectid(project.get());
        projectUser.setUserid(user.get());
        projectUserRepository.save(projectUser);
        return new Result(true, "ProjectUser created successfully");
    }

    public Result updateProjectUser(Integer id, ProjectUserDto projectUserDto) {
        Optional<ProjectUser> byId = projectUserRepository.findById(id);
        if (byId.isPresent()) {
            ProjectUser projectUser = byId.get();
            projectUserDto.setProjectId(projectUserDto.getProjectId());
            projectUserDto.setUserId(projectUserDto.getUserId());
            projectUserRepository.save(projectUser);
            return new Result(true, "ProjectUser updated successfully");
        }
        return new Result(true, "Project user not found");
    }

    public Result deleteProjectUser(Integer id) {
        projectUserRepository.deleteById(id);
        return new Result(true, "ProjectUser deleted successfully");
    }


}
