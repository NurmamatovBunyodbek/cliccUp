package org.example.clickup.controller;

import org.example.clickup.dto.IconDto;
import org.example.clickup.model.Icon;
import org.example.clickup.model.Result;
import org.example.clickup.service.IconService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/icon")
public class IconController {
    @Autowired
    private IconService iconService;

    @GetMapping
    public List<Icon> geticons() {
        return iconService.getAllIcons();
    }

    @GetMapping("/{id}")
    public Icon geticonById(@PathVariable Integer id) {
        return iconService.getIconById(id);
    }

    @PostMapping
    public Result addicon(@RequestBody IconDto iconDto) {
        return iconService.addIcon(iconDto);
    }

    @PutMapping("/{id}")
    public Result updateicon(@PathVariable Integer id, @RequestBody IconDto iconDto) {
        return iconService.updateIcon(id, iconDto);
    }

    @DeleteMapping("/{id}")
    public Result deleteicon(@PathVariable Integer id) {
        return iconService.deleteIcon(id);
    }
}
