package org.example.clickup.service;

import org.example.clickup.dto.TaskHistoryDto;
import org.example.clickup.model.Result;
import org.example.clickup.model.Task;
import org.example.clickup.model.TaskHistory;
import org.example.clickup.repository.TaskHistoryRepository;
import org.example.clickup.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskHistoryService {
    @Autowired
    TaskHistoryRepository taskHistoryRepository;

    @Autowired
    TaskRepository taskRepository;

    public List<TaskHistory> getAllTaskHistories() {
        return taskHistoryRepository.findAll();
    }

    public TaskHistory findById(Integer id) {
        Optional<TaskHistory> byId = taskHistoryRepository.findById(id);
        return byId.get();
    }

    public Result createTaskHistory(TaskHistoryDto taskHistoryDto) {
        Optional<Task> taskOptional = taskRepository.findById(taskHistoryDto.getTaskId());
        TaskHistory taskHistory = new TaskHistory();
        taskHistory.setTaskid(taskOptional.get());
        taskHistory.setChangeFieldName(taskHistoryDto.getChangeFieldName());
        taskHistory.setBefore(taskHistoryDto.getBefore());
        taskHistory.setAfter(taskHistoryDto.getAfter());
        taskHistory.setData(taskHistoryDto.getData());
        taskHistoryRepository.save(taskHistory);
        return new Result(true, "TaskHistory entry created successfully");
        }


    public Result updateTaskHistory(Integer id, TaskHistoryDto taskHistoryDto) {
        Optional<TaskHistory> taskHistoryOptional = taskHistoryRepository.findById(id);
        if (taskHistoryOptional.isPresent()) {
            Optional<Task> taskOptional = taskRepository.findById(taskHistoryDto.getTaskId());
            TaskHistory taskHistory = taskHistoryOptional.get();
            taskHistory.setTaskid(taskOptional.get());
            taskHistory.setChangeFieldName(taskHistoryDto.getChangeFieldName());
            taskHistory.setBefore(taskHistoryDto.getBefore());
            taskHistory.setAfter(taskHistoryDto.getAfter());
            taskHistory.setData(taskHistoryDto.getData());
            taskHistoryRepository.save(taskHistory);
            return new Result(true, "TaskHistory updated successfully");
            }

        return new Result(false, "TaskHistory not found");
    }

    public Result deleteTaskHistory(Integer id) {
        Optional<TaskHistory> byId = taskHistoryRepository.findById(id);
        if (byId.isPresent()) {
            taskHistoryRepository.deleteById(id);
            return new Result(true, "TaskHistory entry deleted successfully");
        }
        return new Result(false, "TaskHistory not found");
    }
}
