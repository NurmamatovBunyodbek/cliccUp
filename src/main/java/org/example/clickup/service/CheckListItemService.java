package org.example.clickup.service;

import org.example.clickup.dto.CheckListItemDto;
import org.example.clickup.model.CheckListItem;
import org.example.clickup.model.Checklist;
import org.example.clickup.model.Result;
import org.example.clickup.repository.CheckListItemRepository;
import org.example.clickup.repository.ChecklistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CheckListItemService {
    @Autowired
    CheckListItemRepository checkListItemRepository;

    @Autowired
    ChecklistRepository checkListRepository;

    public List<CheckListItem> getAllCheckListItems() {
        return checkListItemRepository.findAll();
    }

    public CheckListItem getChekListItemById(Integer id) {
        Optional<CheckListItem> byId = checkListItemRepository.findById(id);
        return byId.get();
    }
    public Result createCheckListItem(CheckListItemDto checkListItemDto) {
        Optional<Checklist> checkListOptional = checkListRepository.findById(checkListItemDto.getCheckListid());
        CheckListItem checkListItem = new CheckListItem();
        checkListItem.setName(checkListItemDto.getName());
        checkListItem.setCheckListid(checkListOptional.get());
        checkListItem.setResolved(checkListItemDto.isResolved());
        checkListItem.setAssignedUserId(checkListItemDto.getAssignedUserid());
        checkListItemRepository.save(checkListItem);
        return new Result(true, "CheckListItem created successfully");
        }


    public Result updateCheckListItem(Integer id, CheckListItemDto checkListItemDto) {
        Optional<Checklist> checkListOptional = checkListRepository.findById(checkListItemDto.getCheckListid());
        if (checkListOptional.isPresent()) {
            Optional<CheckListItem> checkListItemOptional = checkListItemRepository.findById(id);
            CheckListItem checkListItem = checkListItemOptional.get();
            checkListItem.setName(checkListItemDto.getName());
            checkListItem.setCheckListid(checkListOptional.get());
            checkListItem.setResolved(checkListItemDto.isResolved());
            checkListItem.setAssignedUserId(checkListItemDto.getAssignedUserid());
            checkListItemRepository.save(checkListItem);
            return new Result(true, "CheckListItem updated successfully");
            }
        return new Result(false, "CheckListItem not found");
    }

    public Result deleteCheckListItem(Integer id) {
        Optional<CheckListItem> byId = checkListItemRepository.findById(id);
        if (byId.isPresent()) {
            checkListItemRepository.deleteById(id);
            return new Result(true, "CheckListItem deleted successfully");
        }
        return new Result(false, "CheckListItem not found");
    }



}
