package org.example.clickup.controller;

import org.example.clickup.dto.TimeTrackedDto;
import org.example.clickup.model.Result;
import org.example.clickup.model.TimeTracked;
import org.example.clickup.service.TimeTrackedServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/timrtracked")
public class TimeTrackedController {
    @Autowired
    TimeTrackedServise timeTrackedServise;

    @GetMapping
    public List<TimeTracked> getAllTimeTracked() {
        return timeTrackedServise.getAllTimeTracked();
    }

    @GetMapping("/{id}")
    public TimeTracked findTimeTrackedById(@PathVariable Integer id) {
        return timeTrackedServise.findById(id);
    }

    @PostMapping
    public Result createTimeTracked(@RequestBody TimeTrackedDto timeTrackedDto) {
        return timeTrackedServise.createTimeTracked(timeTrackedDto);
    }

    @PutMapping("/{id}")
    public Result updateTimeTracked(@PathVariable Integer id, @RequestBody TimeTrackedDto timeTrackedDto) {
        return timeTrackedServise.updateTimeTracked(id, timeTrackedDto);
    }

    @DeleteMapping("/{id}")
    public Result deleteTimeTracked(@PathVariable Integer id) {
        return timeTrackedServise.deleteTimeTracked(id);
    }


}
