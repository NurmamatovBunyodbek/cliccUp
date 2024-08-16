package org.example.clickup.controller;

import org.example.clickup.dto.SpaceUserDto;
import org.example.clickup.model.Result;
import org.example.clickup.model.SpaceUser;
import org.example.clickup.service.SpaceUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/{spaceuser}")
public class SpaceUserController {
    @Autowired
    SpaceUserService spaceUserService;
    @GetMapping
    public ResponseEntity<List<SpaceUser>> getSpaceUsers() {
        List<SpaceUser> spaceUsers = spaceUserService.getallSpaceUsers();
        return ResponseEntity.ok(spaceUsers);
    }
    @GetMapping("/{id}")
    public List<SpaceUser> getSpaceUserbyId(@PathVariable Integer id) {
        SpaceUser spaceUser = spaceUserService.getSpaceUserById(id);
        return (List<SpaceUser>) spaceUser;
    }
    @PostMapping
    public Result createSpaceUser(@RequestBody SpaceUserDto spaceUserDto) {
        Result spaceUser = spaceUserService.createSpaceUser(spaceUserDto);
        return spaceUser;
    }
    @PutMapping("/{id}")
    public Result updateSpaceUser(@PathVariable Integer id,@RequestBody SpaceUserDto spaceUserDto) {
        Result spaceUser = spaceUserService.updateSpaceUser(id, spaceUserDto);
        return spaceUser;
    }
    @DeleteMapping("/{id}")
    public Result deleteSpaceUser(@PathVariable Integer id) {
        Result spaceUser = spaceUserService.deleteSpaceUser(id);
        return spaceUser;
    }
}

