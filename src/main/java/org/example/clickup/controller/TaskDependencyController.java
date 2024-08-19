package org.example.clickup.controller;

import org.example.clickup.dto.TaskDependencyDto;
import org.example.clickup.model.Result;
import org.example.clickup.model.TaskDependency;
import org.example.clickup.service.TaskDependencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/taskdependency")
public class TaskDependencyController {
    @Autowired
    TaskDependencyService taskDependencyService;

    @GetMapping
    public List<TaskDependency> getAllTaskDependencies() {
        return taskDependencyService.getAllTaskDependencies();
    }

    @GetMapping("/{id}")
    public TaskDependency findTaskDependencyById(@PathVariable Integer id) {
        return taskDependencyService.findById(id);
    }

    @PostMapping
    public Result createTaskDependency(@RequestBody TaskDependencyDto taskDependencyDto) {
        return taskDependencyService.createTaskDependency(taskDependencyDto);
    }

    @PutMapping("/{id}")
    public Result updateTaskDependency(@PathVariable Integer id, @RequestBody TaskDependencyDto taskDependencyDto) {
        return taskDependencyService.updateTaskDependency(id, taskDependencyDto);
    }

    @DeleteMapping("/{id}")
    public Result deleteTaskDependency(@PathVariable Integer id) {
        return taskDependencyService.deleteTaskDependency(id);
    }
}
