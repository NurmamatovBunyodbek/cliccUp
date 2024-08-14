package org.example.clickup.controller;

import org.example.clickup.dto.ClickAppsDto;
import org.example.clickup.model.ClickApps;
import org.example.clickup.model.Result;
import org.example.clickup.service.ClickAppsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clickapps")
public class ClickAppsController {
    @Autowired
    ClickAppsService clickAppsService;

    @GetMapping
    private List<ClickApps> getClickAppsService() {
        return clickAppsService.getALl();
    }

    @GetMapping ("/{id}")
    private ClickApps getClickAppsServicebyid(Integer id) {
        ClickApps clickApps = clickAppsService.getClickAppsBYID(id);
        return clickApps;
    }

    @PostMapping
    private Result addClickApps(@RequestBody ClickAppsDto clickAppsDto) {
        return clickAppsService.addClickApps(clickAppsDto);
    }

    @PutMapping("/{id}")
    private Result updateClickApps(@PathVariable Integer id, @RequestBody ClickAppsDto clickAppsDto) {
        return clickAppsService.updateClickApps(id, clickAppsDto);
    }

    @DeleteMapping("/{id}")
    private Result deleteClickApps(@PathVariable Integer id) {
        return clickAppsService.deleteClickApps(id);
    }


}
