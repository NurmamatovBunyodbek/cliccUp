package org.example.clickup.controller;

import org.example.clickup.dto.WorkSpaceUserDto;
import org.example.clickup.model.Result;
import org.example.clickup.model.WorkSpaceUser;
import org.example.clickup.repository.WorkSpaceUserRepository;
import org.example.clickup.service.WorkSpaceUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/workspaceuser")
public class WorkSpaceUserController {
    //CRUD
    @Autowired
    WorkSpaceUserService workSpaceUserService;
    @GetMapping
    public List<WorkSpaceUser> getWorkSpaceUser() {
        List<WorkSpaceUser> userList = workSpaceUserService.getALl();
        return userList.isEmpty() ? null : userList;
    }
    @GetMapping("/{id}")
    public WorkSpaceUser getWorkSpaceUsersByID(@PathVariable Integer id) {
        return workSpaceUserService.getById(id);
    }
    @PostMapping
    public Result createWorkSpaceUser(@RequestBody WorkSpaceUserDto workSpaceUserDto) {
        Result result = workSpaceUserService.create(workSpaceUserDto);
        return result;
    }
    @PutMapping("/{id}")
    public Result updateWorkSpaceUser(@PathVariable Integer id,@RequestBody WorkSpaceUserDto workSpaceUserDto) {
        Result result = workSpaceUserService.update(id, workSpaceUserDto);
        return result;
    }
    @DeleteMapping("/{id}")
    public Result deleteWorkSpaceUser(@PathVariable Integer id) {
        Result result = workSpaceUserService.delete(id);
        return result;
    }
}
