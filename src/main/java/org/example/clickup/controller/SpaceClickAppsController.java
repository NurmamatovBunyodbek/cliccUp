package org.example.clickup.controller;

import org.example.clickup.dto.SpaceClickAppsDto;
import org.example.clickup.model.Result;
import org.example.clickup.model.SpaceClickApps;
import org.example.clickup.service.SpaceClickAppsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/spaceClickApps")

public class SpaceClickAppsController {
    @Autowired
    SpaceClickAppsService spaceClickAppsService;

    @GetMapping
    public List<SpaceClickApps> getAllSpaceClickApps() {
        return spaceClickAppsService.getSpaceClickApps();
    }

    @GetMapping
    public SpaceClickApps getSpaceClickAppsBySpaceId(@PathVariable Integer id) {
        return spaceClickAppsService.getAllClickAppsBySpaceId(id);
    }

    @PostMapping
    public SpaceClickApps addSpaceClickApps(@RequestBody SpaceClickAppsDto spaceClickAppsDto) {
        return spaceClickAppsService.createSpaceClickApps(spaceClickAppsDto);
    }

    @PutMapping
    public Result updateSpaceClickApps(@PathVariable Integer id, @RequestBody SpaceClickAppsDto spaceClickAppsDto) {
        return spaceClickAppsService.updateSpaceClickApps(id, spaceClickAppsDto);
    }

    @DeleteMapping
    public Result deleteSpaceClickApps(@PathVariable Integer id) {
        return spaceClickAppsService.deleteSpaceClickApps(id);
    }

}
