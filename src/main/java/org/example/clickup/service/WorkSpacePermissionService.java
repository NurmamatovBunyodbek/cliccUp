package org.example.clickup.service;

import org.example.clickup.dto.WorkSpacePermissionDto;
import org.example.clickup.model.Result;
import org.example.clickup.model.WorkSpacePermission;
import org.example.clickup.repository.WorkSpacePermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkSpacePermissionService {
    @Autowired
    WorkSpacePermissionRepository workSpacePermissionRepository;

    public List<WorkSpacePermission> getallWorkSpacePermission() {
        return workSpacePermissionRepository.findAll();
    }
    public WorkSpacePermission getWorkSpacePermissionById(Integer id) {
        return workSpacePermissionRepository.getById(id);
    }
    public Result createWorkSpacePermission(WorkSpacePermissionDto workSpacePermissionDto) {
        WorkSpacePermission workSpacePermission = new WorkSpacePermission();
        Optional<WorkSpacePermission> permissionOptional = workSpacePermissionRepository.findById(workSpacePermissionDto.getWorkSpaceRoleId());
        if (permissionOptional.isPresent()) {
            workSpacePermission.setId(workSpacePermissionDto.getWorkSpaceRoleId());
            workSpacePermissionDto.setPermission(workSpacePermissionDto.getPermission());
            workSpacePermissionRepository.save(workSpacePermission);
            return new Result(true,"Permission created");
        }
        return new Result(false,"WorkSpaceRole not found");

    }
    public Result updateWorkSpacePermission(Integer id,WorkSpacePermissionDto workSpacePermissionDto) {
        Optional<WorkSpacePermission> permissionOptional = workSpacePermissionRepository.findById(id);
        if (permissionOptional.isPresent()) {
            WorkSpacePermission permission = permissionOptional.get();
            permission.setPermission(workSpacePermissionDto.getPermission());
            workSpacePermissionRepository.save(permission);
            return new Result(true,"Permission updated");
        }
        return new Result(false,"Permission not found");
    }
    public Result deleteWorkSpacePermission(Integer id) {
        Optional<WorkSpacePermission> permissionOptional = workSpacePermissionRepository.findById(id);
        if (permissionOptional.isPresent()) {
            workSpacePermissionRepository.delete(permissionOptional.get());
            return new Result(true,"Permission deleted");
        }
        return new Result(false,"Permission not found");
    }
}
