package org.example.clickup.controller;

import org.example.clickup.dto.TaskUserDto;
import org.example.clickup.model.Result;
import org.example.clickup.model.TaskUser;
import org.example.clickup.service.TaskUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/taskuser")
public class TaskUserController {
    @Autowired
     TaskUserService taskUserService;

    @GetMapping
    public List<TaskUser> getAllTaskUsers() {
        return taskUserService.getAllTaskUsers();
    }

    @GetMapping("/{id}")
    public TaskUser findTaskUserById(@PathVariable Integer id) {
        return taskUserService.findById(id);
    }

    @PostMapping
    public Result createTaskUser(@RequestBody TaskUserDto taskUserDto) {
        return taskUserService.createTaskUser(taskUserDto);
    }

    @PutMapping("/{id}")
    public Result updateTaskUser(@PathVariable Integer id, @RequestBody TaskUserDto taskUserDto) {
        return taskUserService.updateTaskUser(id, taskUserDto);
    }

    @DeleteMapping("/{id}")
    public Result deleteTaskUser(@PathVariable Integer id) {
        return taskUserService.deleteTaskUser(id);
    }


}
