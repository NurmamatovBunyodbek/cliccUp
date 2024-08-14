package org.example.clickup.service;

import org.example.clickup.dto.WorkSpaceRoleDto;
import org.example.clickup.dto.WorkspaceDto;
import org.example.clickup.model.Result;
import org.example.clickup.model.WorkSpaceRole;
import org.example.clickup.model.Workspace;
import org.example.clickup.repository.WorkspaceRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkSpaceRoleService {
    @Autowired
    WorkspaceRoleRepository workspaceRoleRepository;

    public List<WorkSpaceRole> getallWorkSpaceRole() {
        List<WorkSpaceRole> workspaceList = workspaceRoleRepository.findAll();
        return workspaceList;
    }

    public WorkSpaceRole getallWorkSpaceRoleByWorkspaceID(Integer id) {
        Optional<WorkSpaceRole> optionalWorkspace = workspaceRoleRepository.findById(id);
        return optionalWorkspace.get();
    }

    public Result addWorkspaceRole(WorkSpaceRoleDto workSpaceRoleDto) {
        WorkSpaceRole workSpaceRole = new WorkSpaceRole();
        workSpaceRole.setName(workSpaceRoleDto.getName());
        workSpaceRole.setExtendRole(workSpaceRoleDto.getExtendRole());
        workspaceRoleRepository.save(workSpaceRole);
        return new Result(true, "Successfully added work space role");

    }

    public Result updateWorkspaceRole(Integer id, WorkSpaceRoleDto workSpaceRoleDto) {
        Optional<WorkSpaceRole> workspaceOptional = workspaceRoleRepository.findById(id);
        if (workspaceOptional.isPresent()) {
            WorkSpaceRole workSpaceRole = new WorkSpaceRole();
            workSpaceRole.setName(workSpaceRoleDto.getName());
            workSpaceRole.setExtendRole(workSpaceRoleDto.getExtendRole());
            workspaceRoleRepository.save(workSpaceRole);
            return new Result(true, "Successfully updated workspace role");
        }
        return new Result(false, "Failed to update workspace role");

    }

    public Result deleteWorkspaceRole(Integer id) {
        Optional<WorkSpaceRole> workspaceOptional = workspaceRoleRepository.findById(id);
        if (workspaceOptional.isPresent()) {
            WorkSpaceRole workSpaceRole = new WorkSpaceRole();
            workSpaceRole.setId(id);
        }
        return new Result(true, "Successfully deleted work space role");

    }


}
