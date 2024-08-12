package org.example.clickup.controller;

import org.example.clickup.dto.WorkspaceDto;
import org.example.clickup.model.Result;
import org.example.clickup.model.Workspace;
import org.example.clickup.service.WorkspaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workspace")
public class WorkspaceController {
    @Autowired
    private WorkspaceService workspaceService;

    @GetMapping
    public List<Workspace> getAllWorkspaces() {
        return workspaceService.getAllWorkspaces();
    }

    @GetMapping("/{id}")
    public Workspace getWorkspaceById(@PathVariable Integer id) {
        return workspaceService.getWorkspaceById(id);
    }

    @PostMapping
    public Result addWorkspace(@RequestBody WorkspaceDto workspaceDto) {
        Result result = workspaceService.addWorkspace(workspaceDto);
        return result;
    }

    @PutMapping("/{id}")
    public Result updateWorkspace(@PathVariable Integer id, @RequestBody WorkspaceDto workspaceDto) {
        Result result = workspaceService.updateWorkspace(id, workspaceDto);
        return result;
    }

    @DeleteMapping("/{id}")
    public Result deleteWorkspace(@PathVariable Integer id) {
        Result result = workspaceService.deleteWorkspace(id);
        return result;
    }
}
