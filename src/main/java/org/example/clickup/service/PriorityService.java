package org.example.clickup.service;

import org.example.clickup.dto.PriorityDto;
import org.example.clickup.model.Icon;
import org.example.clickup.model.Priority;
import org.example.clickup.model.Result;
import org.example.clickup.repository.IconRepository;
import org.example.clickup.repository.PriorityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PriorityService {
    @Autowired
    PriorityRepository priorityRepository;

    @Autowired
    IconRepository iconRepository;

    public List<Priority> getallpriorities(){
        return priorityRepository.findAll();
    }
    public Priority getprioritiesByID(Integer id){
        Optional<Priority> byId = priorityRepository.findById(id);
        return byId.get();
    }
    public Result createPriority(PriorityDto priorityDto) {
        Optional<Icon> iconOptional = iconRepository.findById(priorityDto.getIconId());
        Priority priority = new Priority();
        priority.setName(priorityDto.getName());
        priority.setIconid(iconOptional.get());
        priorityRepository.save(priority);
        return new Result(true, "Priority created successfully");
    }

    public Result updatePriority(Integer id, PriorityDto priorityDto) {
        Optional<Priority> priorityOptional = priorityRepository.findById(id);
        if (priorityOptional.isPresent()) {
        Optional<Icon> iconOptional = iconRepository.findById(id);
        Priority priority = priorityOptional.get();
        priority.setName(priorityDto.getName());
        priority.setIconid(iconOptional.get());
        priorityRepository.save(priority);
        return new Result(true, "Priority updated successfully");
        }
        return new Result(false, "Priority not found");
    }

    public Result deletePriority(Integer id) {
        Optional<Priority> priorityOptional = priorityRepository.findById(id);
        if (priorityOptional.isPresent()) {
            priorityRepository.deleteById(id);
            return new Result(true, "Priority deleted successfully");
        }
        return new Result(false, "Priority not found");
    }
}
