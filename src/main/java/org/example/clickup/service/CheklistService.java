package org.example.clickup.service;

import org.example.clickup.dto.ChecklistDto;
import org.example.clickup.model.Checklist;
import org.example.clickup.model.Result;
import org.example.clickup.model.Task;
import org.example.clickup.repository.ChecklistRepository;
import org.example.clickup.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CheklistService {
    @Autowired
    ChecklistRepository checklistRepository;

    @Autowired
    TaskRepository taskRepository;

    public List<Checklist> getAllChecklists() {
        return checklistRepository.findAll();
    }

    public Checklist getChecklistByID(Integer id) {
        Optional<Checklist> byId = checklistRepository.findById(id);
        return byId.get();
    }
    public Result createChecklist(ChecklistDto checklistDto) {
        Optional<Task> taskOptional = taskRepository.findById(checklistDto.getTaskId());
        Checklist checklist = new Checklist();
        checklist.setName(checklistDto.getName());
        checklist.setTaskid(taskOptional.get());
        checklistRepository.save(checklist);
        return new Result(true, "Checklist created successfully");
    }
    public Result updateChecklist(Integer id,ChecklistDto checklistDto) {
        Optional<Task> byId = taskRepository.findById(id);
        if (byId.isPresent()) {
            Checklist checklist = new Checklist();
            checklist.setName(checklistDto.getName());
            Optional<Task> taskOptional = taskRepository.findById(checklistDto.getTaskId());
            checklist.setTaskid(taskOptional.get());
            checklistRepository.save(checklist);
            return new Result(true, "Checklist created successfully");
        }
        return new Result(false, "Checklist not found");
    }
    public Result deleteChecklist(Integer id) {
        Optional<Checklist> byId = checklistRepository.findById(id);
        if (byId.isPresent()) {
            checklistRepository.delete(byId.get());
            return new Result(true, "Checklist deleted successfully");
        }
        return new Result(false, "Checklist not found");
    }


}
