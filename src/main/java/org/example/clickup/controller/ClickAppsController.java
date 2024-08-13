package org.example.clickup.controller;

import org.example.clickup.dto.ClickAppsDto;
import org.example.clickup.model.Result;
import org.example.clickup.service.ClickAppsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clickapps")
public class ClickAppsController {
    @Autowired
    private ClickAppsService clickAppsService;
    @GetMapping
    private ClickAppsService getClickAppsService() {
        return clickAppsService.getallClickApps();
    }
    /*@GetMapping //nimasidir xato
    private Result getClickAppsServicebyid(Integer id) {
       return clickAppsService.getClickAppsBYID(id);
    }*/
    @PostMapping
    private Result addClickApps(@RequestBody ClickAppsDto clickAppsDto) {
        return clickAppsService.addClickApps(clickAppsDto);
    }
    @PutMapping
    private Result updateClickApps(@PathVariable Integer id,@RequestBody ClickAppsDto clickAppsDto) {
        return clickAppsService.updateClickApps(id, clickAppsDto);
    }
    @DeleteMapping
    private Result deleteClickApps(@PathVariable Integer id) {
        return clickAppsService.deleteClickApps(id);
    }


}
