package org.example.clickup.service;

import org.example.clickup.dto.StatusDto;
import org.example.clickup.model.*;
import org.example.clickup.repository.CategoryRepository;
import org.example.clickup.repository.ProjectRepository;
import org.example.clickup.repository.SpaceRepository;
import org.example.clickup.repository.StatusRepository;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StatusService {
    @Autowired
    StatusRepository statusRepository;

    @Autowired
    SpaceRepository spaceRepository;

    @Autowired
    ProjectRepository projectRepository;
    @Autowired
    CategoryRepository categoryRepository;


    public List<Status> getAllStatuses() {
        return statusRepository.findAll();
    }
    public Status getStatusbyID(Integer id) {
        return statusRepository.findById(id).get();
    }
    public Result createStatus(StatusDto statusDto) {
        Optional<Space> space = spaceRepository.findById(statusDto.getSpaceId());
        Optional<Project> project = projectRepository.findById(statusDto.getProjectId());
        Optional<Category> category = categoryRepository.findById(statusDto.getCategoryId());

        if (space.isPresent() && project.isPresent() && category.isPresent()) {
            Status status = new Status();
            status.setName(statusDto.getName());
            status.setSpaceid(space.get());
            status.setProjectid(project.get());
            status.setCategoryid(category.get());
            status.setColor(statusDto.getColor());
           /* status.setType(statusDto.getType());//xato chiqardi*/
            statusRepository.save(status);
            return new Result(true, "Status created successfully");
        }
        return new Result(false, "Space, Project, or Category not found");
    }
    public Result updateStatus(Integer id, StatusDto statusDto) {
        Optional<Status> existingStatus = statusRepository.findById(id);
        if (existingStatus.isPresent()) {
            Status status = existingStatus.get();
            Optional<Space> space = spaceRepository.findById(statusDto.getSpaceId());
            Optional<Project> project = projectRepository.findById(statusDto.getProjectId());
            Optional<Category> category = categoryRepository.findById(statusDto.getCategoryId());

            if (space.isPresent() && project.isPresent() && category.isPresent()) {
                status.setName(statusDto.getName());
                status.setSpaceid(space.get());
                status.setProjectid(project.get());
                status.setCategoryid(category.get());
                status.setColor(statusDto.getColor());
                /*status.setType(statusDto.getType());*/
                statusRepository.save(status);
                return new Result(true, "Status updated successfully");
            }
            return new Result(false, "Space, Project, or Category not found");
        }
        return new Result(false, "Status not found");
    }
    public Result deleteStatus(Integer id) {
        Optional<Status> existingStatus = statusRepository.findById(id);
        if (existingStatus.isPresent()) {
            Status status = existingStatus.get();
            statusRepository.delete(status);
            return new Result(true, "Status deleted successfully");
        }
        return new Result(false, "Status not found");
    }

}
