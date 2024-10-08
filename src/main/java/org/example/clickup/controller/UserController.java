package org.example.clickup.controller;


import org.example.clickup.dto.UserDto;
import org.example.clickup.model.Result;
import org.example.clickup.model.User;
import org.example.clickup.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserbyId(@PathVariable Integer id) {
        return userService.findUserById(id);
    }

    @PostMapping
    public Result createUser(@RequestBody UserDto userDto) {
        Result result = userService.addUser(userDto);
        return result;
    }

    @PutMapping("/{id}")
    public Result updateUser(@PathVariable Integer id, @RequestBody UserDto userDto) {
        Result result = userService.updateUser(id, userDto);
        return result;
    }

    @DeleteMapping("/{id}")
    public Result deleteUser(@PathVariable Integer id) {
        Result result = userService.deleteUser(id);
        return result;
    }


}
