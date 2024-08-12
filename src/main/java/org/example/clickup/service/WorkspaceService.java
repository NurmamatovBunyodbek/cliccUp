package org.example.clickup.service;

import org.example.clickup.dto.WorkspaceDto;
import org.example.clickup.model.Result;
import org.example.clickup.model.Workspace;
import org.example.clickup.repository.WorkspaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkspaceService {
    @Autowired
    private WorkspaceRepository workspaceRepository;

    public List<Workspace> getAllWorkspaces() {
        return workspaceRepository.findAll();
    }

    public Workspace getWorkspaceById(Integer id) {
        Optional<Workspace> workspace = workspaceRepository.findById(id);
        return workspace.get();
    }

    public Result addWorkspace(WorkspaceDto workspaceDto) {
        Workspace workspace = new Workspace();
        workspace.setName(workspaceDto.getName());
        workspace.setColor(workspaceDto.getColor());
        workspaceRepository.save(workspace);
        return new Result(true, "Successfully added workspace");
    }

    public Result updateWorkspace(Integer id, WorkspaceDto workspaceDto) {
        Optional<Workspace> workspaceOptional = workspaceRepository.findById(id);
        if (workspaceOptional.isPresent()) {
            Workspace workspace = workspaceOptional.get();
            workspace.setName(workspaceDto.getName());
            workspace.setColor(workspaceDto.getColor());
            workspaceRepository.save(workspace);
            return new Result(true, "Successfully updated workspace");
        }
        return new Result(false, "Workspace not found");
    }

    public Result deleteWorkspace(Integer id) {
        Optional<Workspace> workspaceOptional = workspaceRepository.findById(id);
        if (workspaceOptional.isPresent()) {
            workspaceRepository.delete(workspaceOptional.get());
            return new Result(true, "Successfully deleted workspace");
        }
        return new Result(false, "Workspace not found");
    }
}
