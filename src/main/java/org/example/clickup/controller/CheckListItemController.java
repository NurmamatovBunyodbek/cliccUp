package org.example.clickup.controller;

import org.example.clickup.dto.CheckListItemDto;
import org.example.clickup.model.CheckListItem;
import org.example.clickup.model.Result;
import org.example.clickup.service.CheckListItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/checklistitem")
public class CheckListItemController {
    @Autowired
    private CheckListItemService checkListItemService;

    @GetMapping
    public List<CheckListItem> getAllCheckListItems() {
        return checkListItemService.getAllCheckListItems();
    }

    @GetMapping("/{id}")
    public CheckListItem findCheckListItemById(@PathVariable Integer id) {
        return checkListItemService.getChekListItemById(id);
    }

    @PostMapping
    public Result createCheckListItem(@RequestBody CheckListItemDto checkListItemDto) {
        return checkListItemService.createCheckListItem(checkListItemDto);
    }

    @PutMapping("/{id}")
    public Result updateCheckListItem(@PathVariable Integer id, @RequestBody CheckListItemDto checkListItemDto) {
        return checkListItemService.updateCheckListItem(id, checkListItemDto);
    }

    @DeleteMapping("/{id}")
    public Result deleteCheckListItem(@PathVariable Integer id) {
        return checkListItemService.deleteCheckListItem(id);
    }
}
