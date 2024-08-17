package org.example.clickup.service;

import org.example.clickup.dto.TaskDto;
import org.example.clickup.model.*;
import org.example.clickup.repository.CategoryRepository;
import org.example.clickup.repository.PriorityRepository;
import org.example.clickup.repository.StatusRepository;
import org.example.clickup.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private StatusRepository statusRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private PriorityRepository priorityRepository;

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }
    public Task getTaskById(Integer id) {
        Optional<Task> byId = taskRepository.findById(id);
        return byId.get();
    }
    public Result createTask(TaskDto taskDto) {
        Task task = new Task();
        task.setName(taskDto.getName());
        task.setDescription(taskDto.getDescription());
        Optional<Status> statusOptional = statusRepository.findById(taskDto.getStatusId());
        task.setStatusid(statusOptional.get());
        Optional<Category> categoryOptional = categoryRepository.findById(taskDto.getCategoryId());
        task.setCategoryid(categoryOptional.get());
        Optional<Priority> priorityOptional = priorityRepository.findById(taskDto.getPriorityId());
        task.setPriorityid(priorityOptional.get());
        task.setParentTaskId(taskDto.getParentTaskId());
        task.setStartedDate(taskDto.getStartedDate());
        task.setStartDateHas(taskDto.isStartDateHas());
        task.setDueDate(taskDto.getDueDate());
        task.setDueDateHas(taskDto.isDueDateHas());
        task.setEstimateDate(taskDto.getEstimateDate());
        task.setActivedDate(taskDto.getActivedDate());
        taskRepository.save(task);
        return new Result(true, "Task created successfully");
    }
    public Result updateTask(Integer id, TaskDto taskDto) {
        Optional<Task> byId = taskRepository.findById(id);
        if (byId.isPresent()) {
            Task task = byId.get();
            Optional<Status> statusOptional = statusRepository.findById(taskDto.getStatusId());
            Optional<Category> categoryOptional = categoryRepository.findById(taskDto.getCategoryId());
            Optional<Priority> priorityOptional = priorityRepository.findById(taskDto.getPriorityId());
            task.setName(taskDto.getName());
            task.setDescription(taskDto.getDescription());
            task.setStatusid(statusOptional.get());
            task.setCategoryid(categoryOptional.get());
            task.setPriorityid(priorityOptional.get());
            task.setParentTaskId(taskDto.getParentTaskId());
            task.setStartedDate(taskDto.getStartedDate());
            task.setStartDateHas(taskDto.isStartDateHas());
            task.setDueDate(taskDto.getDueDate());
            task.setDueDateHas(taskDto.isDueDateHas());
            task.setEstimateDate(taskDto.getEstimateDate());
            task.setActivedDate(taskDto.getActivedDate());
            taskRepository.save(task);
            return new Result(true, "Task updated successfully");
        }
        return new Result(false, "Task not found");

        }
    public Result deleteTask(Integer id) {
        taskRepository.deleteById(id);
        return new Result(true, "Task deleted successfully");
    }

}