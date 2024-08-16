package org.example.clickup.controller;

import lombok.Data;
import org.example.clickup.dto.WorkSpacePermissionDto;
import org.example.clickup.model.Result;
import org.example.clickup.model.WorkSpacePermission;
import org.example.clickup.repository.WorkSpacePermissionRepository;
import org.example.clickup.service.WorkSpacePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workspacepermission")
public class WorkSpacePermissionController {
    @Autowired
    WorkSpacePermissionService workSpacePermissionService;

    @GetMapping
    public List<WorkSpacePermission> getWorkSpaceallPermissionService(@RequestBody WorkSpacePermissionDto workSpacePermissionDto) {
        return workSpacePermissionService.getallWorkSpacePermission();
    }

    @GetMapping("/{id}")
    public WorkSpacePermission getWorkSpaceallPermissionServiceByid(@PathVariable Integer id) {
        WorkSpacePermission workSpacePermissionById = workSpacePermissionService.getWorkSpacePermissionById(id);
        return workSpacePermissionById;

    }

    @PostMapping
    public Result addWorkSpacePermissionService(@RequestBody WorkSpacePermissionDto workSpacePermissionDto) {
        return workSpacePermissionService.createWorkSpacePermission(workSpacePermissionDto);
    }

    @PutMapping("/{id}")
    public Result updateWorkSpacePermissionService(@PathVariable Integer id, @RequestBody WorkSpacePermissionDto workSpacePermissionDto) {
        return workSpacePermissionService.updateWorkSpacePermission(id, workSpacePermissionDto);
    }

    @DeleteMapping("/{id}")
    public Result deleteWorkSpacePermissionService(@PathVariable Integer id) {
        return workSpacePermissionService.deleteWorkSpacePermission(id);
    }
}
