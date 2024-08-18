package org.example.clickup.controller;

import org.example.clickup.dto.TaskAttachmentDto;
import org.example.clickup.model.Result;
import org.example.clickup.model.TaskAttachment;
import org.example.clickup.service.TaskAttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/taskattachment")
public class TaskAttachmentController {
    @Autowired
    private TaskAttachmentService taskAttachmentService;
    @GetMapping
    public List<TaskAttachment> getAllTaskAttachments() {
        return taskAttachmentService.getAllTaskAttachments();
    }

    @GetMapping("/{id}")
    public TaskAttachment findTaskAttachmentById(@PathVariable Integer id) {
        return taskAttachmentService.getTaskAttachmentById(id);
    }

    @PostMapping
    public Result createTaskAttachment(@RequestBody TaskAttachmentDto taskAttachmentDto) {
        return taskAttachmentService.createTaskAttachment(taskAttachmentDto);
    }

    @PutMapping("/{id}")
    public Result updateTaskAttachment(@PathVariable Integer id, @RequestBody TaskAttachmentDto taskAttachmentDto) {
        return taskAttachmentService.updateTaskAttachment(id, taskAttachmentDto);
    }

    @DeleteMapping("/{id}")
    public Result deleteTaskAttachment(@PathVariable Integer id) {
        return taskAttachmentService.deleteTaskAttachment(id);
    }

}
