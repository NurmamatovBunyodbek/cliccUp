package org.example.clickup.controller;

import org.example.clickup.dto.TaskHistoryDto;
import org.example.clickup.model.Result;
import org.example.clickup.model.TaskHistory;
import org.example.clickup.service.TaskHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/taskhistory")
public class TaskHistoryController {
    @Autowired
    private TaskHistoryService taskHistoryService;

    @GetMapping
    public List<TaskHistory> getAllTaskHistories() {
        return taskHistoryService.getAllTaskHistories();
    }

    @GetMapping("/{id}")
    public TaskHistory findTaskHistoryById(@PathVariable Integer id) {
        return taskHistoryService.findById(id);
    }

    @PostMapping
    public Result createTaskHistory(@RequestBody TaskHistoryDto taskHistoryDto) {
        return taskHistoryService.createTaskHistory(taskHistoryDto);
    }

    @PutMapping("/{id}")
    public Result updateTaskHistory(@PathVariable Integer id, @RequestBody TaskHistoryDto taskHistoryDto) {
        return taskHistoryService.updateTaskHistory(id, taskHistoryDto);
    }

    @DeleteMapping("/{id}")
    public Result deleteTaskHistory(@PathVariable Integer id) {
        return taskHistoryService.deleteTaskHistory(id);
    }


}
