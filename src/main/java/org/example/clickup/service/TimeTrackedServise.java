package org.example.clickup.service;

import org.example.clickup.dto.TimeTrackedDto;
import org.example.clickup.model.Result;
import org.example.clickup.model.Task;
import org.example.clickup.model.TimeTracked;
import org.example.clickup.repository.TaskRepository;
import org.example.clickup.repository.TimeTrackedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TimeTrackedServise {
    @Autowired
    TimeTrackedRepository timeTrackedRepository;

    @Autowired
    TaskRepository taskRepository;

    public List<TimeTracked> getAllTimeTracked() {
        return timeTrackedRepository.findAll();
    }

    public TimeTracked findById(Integer id) {
        Optional<TimeTracked> byId = timeTrackedRepository.findById(id);
        return byId.get();
    }

    public Result createTimeTracked(TimeTrackedDto timeTrackedDto) {
        Optional<Task> taskOptional = taskRepository.findById(timeTrackedDto.getTaskId());
        TimeTracked timeTracked = new TimeTracked();
        timeTracked.setTaskid(taskOptional.get());
        timeTracked.setStartedAt(timeTrackedDto.getStartedAt());
        timeTracked.setStoppedAt(timeTrackedDto.getStoppedAt());
        timeTrackedRepository.save(timeTracked);
        return new Result(true, "TimeTracked entry created successfully");

    }


    public Result updateTimeTracked(Integer id, TimeTrackedDto timeTrackedDto) {
        Optional<TimeTracked> timeTrackedOptional = timeTrackedRepository.findById(id);
        if (timeTrackedOptional.isPresent()) {
            Optional<Task> taskOptional = taskRepository.findById(timeTrackedDto.getTaskId());
            TimeTracked timeTracked = timeTrackedOptional.get();
            timeTracked.setTaskid(taskOptional.get());
            timeTracked.setStartedAt(timeTrackedDto.getStartedAt());
            timeTracked.setStoppedAt(timeTrackedDto.getStoppedAt());
            timeTrackedRepository.save(timeTracked);
            return new Result(true, "TimeTracked entry updated successfully");
            }

        return new Result(false, "TimeTracked entry not found");
    }

    public Result deleteTimeTracked(Integer id) {
        Optional<TimeTracked> trackedOptional = timeTrackedRepository.findById(id);
        if (trackedOptional.isPresent()) {
            timeTrackedRepository.deleteById(id);
            return new Result(true, "TimeTracked entry deleted successfully");
        }
        return new Result(false, "TimeTracked entry not found");
    }
}
