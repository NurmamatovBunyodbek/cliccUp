package org.example.clickup.controller;

import org.example.clickup.dto.ChecklistDto;
import org.example.clickup.model.Checklist;
import org.example.clickup.model.Result;
import org.example.clickup.service.CheklistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CheklistController {
    @Autowired
    CheklistService cheklistService;
    @GetMapping
    public List<Checklist> getAllChecklists() {
        return cheklistService.getAllChecklists();
    }

    @GetMapping("/{id}")
    public Checklist findChecklistById(@PathVariable Integer id) {
        return cheklistService.getChecklistByID(id);
    }
    @PostMapping
    public Result createChecklist(@RequestBody ChecklistDto checklistDto) {
        return cheklistService.createChecklist(checklistDto);
    }
    @PutMapping
    public Result updateChecklist(@PathVariable Integer id,@RequestBody ChecklistDto checklistDto) {
        return cheklistService.updateChecklist(id, checklistDto);
    }
    @DeleteMapping
    public Result deleteChecklist(@PathVariable Integer id) {
        return cheklistService.deleteChecklist(id);
    }
}
