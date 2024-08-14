package org.example.clickup.controller;

import org.example.clickup.dto.WorkSpaceRoleDto;
import org.example.clickup.model.Result;
import org.example.clickup.model.WorkSpaceRole;
import org.example.clickup.model.Workspace;
import org.example.clickup.service.WorkSpaceRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workspaceRole")
public class WorkSpaceRoleController {


    @Autowired
    WorkSpaceRoleService workSpaceRoleService;

    @GetMapping
    public List<WorkSpaceRole> getAll() {
        return workSpaceRoleService.getallWorkSpaceRole();
    }

    @GetMapping("/{id}")
    public WorkSpaceRole getWSRById(@PathVariable Integer id) {
        return  workSpaceRoleService.getallWorkSpaceRoleByWorkspaceID(id);
    }

    @PostMapping
    public Result addWSR(@RequestBody WorkSpaceRoleDto workSpaceRoleDto) {
        return workSpaceRoleService.addWorkspaceRole(workSpaceRoleDto);
    }

    @PutMapping("/{id}")
    public Result updateWSR(@PathVariable Integer id, @RequestBody WorkSpaceRoleDto workSpaceRoleDto) {
        return workSpaceRoleService.updateWorkspaceRole(id, workSpaceRoleDto);
    }

    @DeleteMapping("/{id}")
    public Result deleteWSR(@PathVariable Integer id) {
        return workSpaceRoleService.deleteWorkspaceRole(id);
    }
}
