package org.example.clickup.controller;

import org.example.clickup.dto.SpaceViewDto;
import org.example.clickup.model.Result;
import org.example.clickup.model.SpaceView;
import org.example.clickup.service.SpaceViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SpaceViewController {
    @Autowired
    private SpaceViewService spaceViewService;
    @GetMapping
    public List<SpaceView> getAllSpaceViews() {
        return spaceViewService.getAllSpaceViews();
    }
    @GetMapping("/{id}")
    public SpaceView getSpaceViewById(@PathVariable Integer id) {
        return spaceViewService.getSpaceViewById(id);
    }
    @PostMapping
    public Result createSpaceView(@RequestBody SpaceViewDto spaceViewDto) {
        return spaceViewService.createSpaceView(spaceViewDto);
    }
    @PutMapping("/{id}")
    public Result updateSpaceView(@PathVariable Integer id, @RequestBody SpaceViewDto spaceViewDto) {
        return spaceViewService.updateSpaceView(id, spaceViewDto);
    }

    @DeleteMapping("/{id}")
    public Result deleteSpaceView(@PathVariable Integer id) {
        return spaceViewService.deleteSpaceView(id);
    }

}
