package org.example.clickup.controller;

import org.example.clickup.dto.PriorityDto;
import org.example.clickup.model.Priority;
import org.example.clickup.model.Result;
import org.example.clickup.service.PriorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/priority")
public class PriorityController {
    @Autowired
    PriorityService priorityService;

    @GetMapping
    public List<Priority> getAllPriorities() {
        return priorityService.getallpriorities();
    }
    @GetMapping("/{id}")
    public Priority getPriorityById(@PathVariable Integer id) {
        return priorityService.getprioritiesByID(id);
    }
    @PostMapping
    public Result addPriority(@RequestBody PriorityDto priorityDto) {
        return priorityService.createPriority(priorityDto);
    }
    @PutMapping("/{id}")
    public Result updatePriority(@PathVariable Integer id,@RequestBody PriorityDto priorityDto) {
        return priorityService.updatePriority(id, priorityDto);
    }
    @DeleteMapping("/{id}")
    public Result deletePriority(@PathVariable Integer id) {
        return priorityService.deletePriority(id);
    }
}
