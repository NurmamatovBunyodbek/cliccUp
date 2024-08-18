package org.example.clickup.service;

import org.example.clickup.dto.TaskDependencyDto;
import org.example.clickup.model.Result;
import org.example.clickup.model.Task;
import org.example.clickup.model.TaskDependency;
import org.example.clickup.repository.TaskDependencyRepository;
import org.example.clickup.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskDependencyService {
    @Autowired
    TaskDependencyRepository taskDependencyRepository;

    @Autowired
    TaskRepository taskRepository;

    public List<TaskDependency> getAllTaskDependencies() {
        return taskDependencyRepository.findAll();
    }

    public TaskDependency findById(Integer id) {
        return taskDependencyRepository.findById(id).orElse(null);
    }

    public Result createTaskDependency(TaskDependencyDto taskDependencyDto) {
        Optional<Task> taskOptional = taskRepository.findById(taskDependencyDto.getTaskid());
        TaskDependency taskDependency = new TaskDependency();
        taskDependency.setTaskid(taskOptional.get());
        taskDependency.setDependencyTaskId(taskDependencyDto.getDependencyTaskId());
        taskDependency.setDependencyType(taskDependencyDto.getDependencyType());
        taskDependencyRepository.save(taskDependency);
        return new Result(true, "TaskDependency entry created successfully");
    }



    public Result updateTaskDependency(Integer id, TaskDependencyDto taskDependencyDto) {
        Optional<TaskDependency> taskDependencyOptional = taskDependencyRepository.findById(id);

        if (taskDependencyOptional.isPresent()) {
            Optional<Task> taskOptional = taskRepository.findById(taskDependencyDto.getTaskid());

            if (taskOptional.isPresent()) {
                TaskDependency taskDependency = taskDependencyOptional.get();
                taskDependency.setTaskid(taskOptional.get());
                taskDependency.setDependencyTaskId(taskDependencyDto.getDependencyTaskId());
                taskDependency.setDependencyType(taskDependencyDto.getDependencyType());
                taskDependencyRepository.save(taskDependency);
                return new Result(true, "TaskDependency entry updated successfully");
            }
            return new Result(false, "Task not found");
        }
        return new Result(false, "TaskDependency entry not found");
    }

    public Result deleteTaskDependency(Integer id) {
        Optional<TaskDependency> dependencyOptional = taskDependencyRepository.findById(id);
        if (dependencyOptional.isPresent()) {
            taskDependencyRepository.deleteById(id);
            return new Result(true, "TaskDependency entry deleted successfully");
        }
        return new Result(false, "TaskDependency entry not found");

    }
}
