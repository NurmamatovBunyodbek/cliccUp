package org.example.clickup.service;

import org.example.clickup.dto.TaskUserDto;
import org.example.clickup.model.Result;
import org.example.clickup.model.Task;
import org.example.clickup.model.TaskUser;
import org.example.clickup.model.User;
import org.example.clickup.repository.TaskRepository;
import org.example.clickup.repository.TaskUserRepository;
import org.example.clickup.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskUserService {
    @Autowired
    TaskUserRepository taskUserRepository;

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    UserRepository userRepository;


    public List<TaskUser> getAllTaskUsers() {
        return taskUserRepository.findAll();
    }

    public TaskUser findById(Integer id) {
        Optional<TaskUser> byId = taskUserRepository.findById(id);
        return byId.get();
    }

    public Result createTaskUser(TaskUserDto taskUserDto) {
        Optional<Task> taskOptional = taskRepository.findById(taskUserDto.getTaskId());
        Optional<User> userOptional = userRepository.findById(taskUserDto.getUserId());
        TaskUser taskUser = new TaskUser();
        taskUser.setTaskid(taskOptional.get());
        taskUser.setUserid(userOptional.get());
        taskUserRepository.save(taskUser);
        return new Result(true, "TaskUser entry created successfully");

    }

    public Result updateTaskUser(Integer id, TaskUserDto taskUserDto) {
        Optional<TaskUser> taskUserOptional = taskUserRepository.findById(id);

        if (taskUserOptional.isPresent()) {
            Optional<Task> taskOptional = taskRepository.findById(taskUserDto.getTaskId());
            Optional<User> userOptional = userRepository.findById(taskUserDto.getUserId());
            TaskUser taskUser = taskUserOptional.get();
            taskUser.setTaskid(taskOptional.get());
            taskUser.setUserid(userOptional.get());
            taskUserRepository.save(taskUser);
            return new Result(true, "TaskUser entry updated successfully");

        }
        return new Result(false, "TaskUser entry not found");
    }

    public Result deleteTaskUser(Integer id) {
        Optional<TaskUser> byId = taskUserRepository.findById(id);
        if (byId.isPresent()) {
            taskUserRepository.deleteById(id);
            return new Result(true, "TaskUser entry deleted successfully");
        }
        return new Result(false, "TaskUser entry not found");
    }

}
