package org.example.clickup.service;

import org.example.clickup.dto.TaskTagDto;
import org.example.clickup.model.Result;
import org.example.clickup.model.Tag;
import org.example.clickup.model.Task;
import org.example.clickup.model.TaskTag;
import org.example.clickup.repository.TagRepository;
import org.example.clickup.repository.TaskRepository;
import org.example.clickup.repository.TaskTagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskTagService {
    @Autowired
    TaskTagRepository taskTagRepository;

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    TagRepository tagRepository;

    public List<TaskTag> getAllTaskTags() {
        return taskTagRepository.findAll();
    }

    public TaskTag findById(Integer id) {
        Optional<TaskTag> tagOptional = taskTagRepository.findById(id);
        return tagOptional.get();
    }
    public Result createTaskTag(TaskTagDto taskTagDto) {
        Optional<Task> taskOptional = taskRepository.findById(taskTagDto.getTaskid());
        Optional<Tag> tagOptional = tagRepository.findById(taskTagDto.getTagid());
        TaskTag taskTag = new TaskTag();
        taskTag.setTaskid(taskOptional.get());
        taskTag.setTagid(tagOptional.get());
        taskTagRepository.save(taskTag);
        return new Result(true, "TaskTag created successfully");
        }


    public Result updateTaskTag(Integer id, TaskTagDto taskTagDto) {
        Optional<TaskTag> taskTagOptional = taskTagRepository.findById(id);
        if (taskTagOptional.isPresent()) {
            Optional<Task> taskOptional = taskRepository.findById(taskTagDto.getTaskid());
            Optional<Tag> tagOptional = tagRepository.findById(taskTagDto.getTagid());
            TaskTag taskTag = taskTagOptional.get();
            taskTag.setTaskid(taskOptional.get());
            taskTag.setTagid(tagOptional.get());
            taskTagRepository.save(taskTag);
            return new Result(true, "TaskTag updated successfully");
        }
        return new Result(false, "TaskTag not found");
    }

    public Result deleteTaskTag(Integer id) {
        Optional<TaskTag> tagOptional = taskTagRepository.findById(id);
        if (tagOptional.isPresent()) {
            taskTagRepository.deleteById(id);
            return new Result(true, "TaskTag deleted successfully");
        }
        return new Result(false, "TaskTag not found");
    }
}
