package com.example.HelloEvents.controller;

import com.example.HelloEvents.dto.UserDto;
import com.example.HelloEvents.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    public UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/allUsers")
    public List<UserDto> getallUsers() {
        return userService.getAllUsers();
    }

    @PostMapping
    public UserDto addUser(@RequestBody UserDto userDto) {
        return userService.SaveUser(userDto);
    }

    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable Long id) {
        return userService.getUserByid(id);
    }

    @PutMapping("/{id}")
    public UserDto updateUser(@PathVariable Long id, @RequestBody UserDto userDto) {
        return userService.modifierUser(id, userDto);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
