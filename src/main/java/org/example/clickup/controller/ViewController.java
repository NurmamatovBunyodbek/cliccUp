package org.example.clickup.controller;

import org.example.clickup.dto.ViewDto;
import org.example.clickup.model.Result;
import org.example.clickup.model.View;
import org.example.clickup.service.ViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/view")
public class ViewController {
    @Autowired
    ViewService viewService;

    @GetMapping
    public List<View> getView() {
        return viewService.getallViews();
    }

    @GetMapping("/{id}")
    public View getViewBYID(@PathVariable Integer id) {
        return viewService.getViewById(id);
    }

    @PostMapping
    public Result createView(@RequestBody ViewDto viewDto) {
        return viewService.addView(viewDto);
    }

    @PostMapping("/{id}")
    public Result updateView(@PathVariable Integer id, @RequestBody ViewDto viewDto) {
        return viewService.updateView(id, viewDto);
    }

    @DeleteMapping("/{id}")
    public Result deleteView(@PathVariable Integer id) {
        return viewService.deleteView(id);
    }

}
