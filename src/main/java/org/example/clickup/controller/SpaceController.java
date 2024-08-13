package org.example.clickup.controller;

import org.example.clickup.dto.SpaceDto;
import org.example.clickup.model.Result;
import org.example.clickup.model.Space;
import org.example.clickup.service.SpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/space")
public class SpaceController {
    @Autowired
    private SpaceService spaceService;
    @GetMapping
    public List<Space> getSpaces() {
        return spaceService.getAllSpaces();
    }
    @GetMapping
    public Space getSpaceById(@PathVariable Integer id) {
        return spaceService.getSpaceById(id);
    }
    @PostMapping
    public Result addSpace(@RequestBody SpaceDto spaceDto) {
        return spaceService.addSpace(spaceDto);
    }
    @PutMapping
    public Result updateSpace(@PathVariable Integer id,@RequestBody SpaceDto spaceDto) {
        return spaceService.updateSpace(id, spaceDto);
    }
    @DeleteMapping
    public Result deleteSpace(@PathVariable Integer id) {
        return spaceService.deleteSpace(id);
    }
}
