package org.example.clickup.controller;

import org.example.clickup.dto.WorkSpaceRoleDto;
import org.example.clickup.model.Result;
import org.example.clickup.model.Workspace;
import org.example.clickup.service.WorkSpaceRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class WorkSpaceRoleController {
    @Autowired
    private WorkSpaceRoleService workSpaceRoleService;
    @GetMapping
    public List<Workspace> getAll() {
        return workSpaceRoleService.getallWorkSpaceRole();
    }
    @GetMapping
    public Workspace getWSRById(@PathVariable Integer id) {
        return (Workspace) workSpaceRoleService.getallWorkSpaceRoleByWorkspaceID(id);
    }
    @PostMapping
    public Result addWSR(@RequestBody WorkSpaceRoleDto workSpaceRoleDto) {
        return workSpaceRoleService.addWorkspaceRole(workSpaceRoleDto);
    }
    @PutMapping
    public Result updateWSR(@PathVariable Integer id,@RequestBody WorkSpaceRoleDto workSpaceRoleDto) {
        return workSpaceRoleService.updateWorkspaceRole(id, workSpaceRoleDto);
    }
    @DeleteMapping
    public Result deleteWSR(@PathVariable Integer id) {
        return workSpaceRoleService.deleteWorkspaceRole(id);
    }
}
