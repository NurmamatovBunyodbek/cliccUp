package org.example.clickup.controller;

import org.example.clickup.dto.TaskTagDto;
import org.example.clickup.model.Result;
import org.example.clickup.model.TaskTag;
import org.example.clickup.service.TaskTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasktag")
public class TaskTagController {
    @Autowired
    private TaskTagService taskTagService;

    @GetMapping
    public List<TaskTag> getAllTaskTags() {
        return taskTagService.getAllTaskTags();
    }

    @GetMapping("/{id}")
    public TaskTag findTaskTagById(@PathVariable Integer id) {
        return taskTagService.findById(id);
    }
    @PostMapping
    public Result createTaskTag(@RequestBody TaskTagDto taskTagDto) {
        return taskTagService.createTaskTag(taskTagDto);
    }

    @PutMapping("/{id}")
    public Result updateTaskTag(@PathVariable Integer id, @RequestBody TaskTagDto taskTagDto) {
        return taskTagService.updateTaskTag(id, taskTagDto);
    }

    @DeleteMapping("/{id}")
    public Result deleteTaskTag(@PathVariable Integer id) {
        return taskTagService.deleteTaskTag(id);
    }
}
