package org.example.clickup.service;

import org.example.clickup.dto.TaskAttachmentDto;
import org.example.clickup.model.Attachment;
import org.example.clickup.model.Result;
import org.example.clickup.model.Task;
import org.example.clickup.model.TaskAttachment;
import org.example.clickup.repository.AttachmentRepository;
import org.example.clickup.repository.TaskAttachmentRepository;
import org.example.clickup.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskAttachmentService {
    @Autowired
    TaskAttachmentRepository taskAttachmentRepository;

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private AttachmentRepository attachmentRepository;

    public List<TaskAttachment> getAllTaskAttachments() {
        return taskAttachmentRepository.findAll();
    }

    public TaskAttachment getTaskAttachmentById(Integer id) {
        Optional<TaskAttachment> byId = taskAttachmentRepository.findById(id);
        return byId.get();
    }
    public Result createTaskAttachment(TaskAttachmentDto taskAttachmentDto) {
        Optional<Task> taskOptional = taskRepository.findById(taskAttachmentDto.getTaskid());
        Optional<Attachment> attachmentOptional = attachmentRepository.findById(taskAttachmentDto.getAttachmentid());
        TaskAttachment taskAttachment = new TaskAttachment();
        taskAttachment.setTaskid(taskOptional.get());
        taskAttachment.setAttachmentid(attachmentOptional.get());
        taskAttachment.setPinCoverImage(taskAttachmentDto.isPinCoverImage());
        taskAttachmentRepository.save(taskAttachment);
        return new Result(true,"TaskAttachment created");
    }
    public Result updateTaskAttachment(Integer id, TaskAttachmentDto taskAttachmentDto) {
        Optional<TaskAttachment> taskAttachmentOptional = taskAttachmentRepository.findById(id);

        if (taskAttachmentOptional.isPresent()) {
            Optional<Task> taskOptional = taskRepository.findById(taskAttachmentDto.getTaskid());
            Optional<Attachment> attachmentOptional = attachmentRepository.findById(taskAttachmentDto.getAttachmentid());
            TaskAttachment taskAttachment = taskAttachmentOptional.get();
            taskAttachment.setTaskid(taskOptional.get());
            taskAttachment.setAttachmentid(attachmentOptional.get());
            taskAttachment.setPinCoverImage(taskAttachmentDto.isPinCoverImage());
            taskAttachmentRepository.save(taskAttachment);
            return new Result(true, "TaskAttachment updated successfully");
        }
        return new Result(false, "TaskAttachment not found");
    }
    public Result deleteTaskAttachment(Integer id) {
        Optional<TaskAttachment> taskAttachmentOptional = taskAttachmentRepository.findById(id);
        if (taskAttachmentOptional.isPresent()) {
            taskAttachmentRepository.deleteById(id);
            return new Result(true, "TaskAttachment deleted successfully");
        }
        return new Result(true, "TaskAttachment deleted successfully");
    }

}
