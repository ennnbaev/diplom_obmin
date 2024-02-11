package com.example1.demo.user.controller;

import com.example1.demo.user.dto.UserInfoDto;
import com.example1.demo.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("my-info/{id}")
    public UserInfoDto getUserInfo(@PathVariable String id) throws Exception {
        return userService.getUserInfo(id);
    }

    @DeleteMapping("{id}")
    public void deleteUserAccount(@PathVariable String id) {
        userService.deleteUserAccount(id);
    }

    @PostMapping
    public void createUser(@RequestBody UserInfoDto userInfoDto) {
        userService.createUser(userInfoDto);
    }

    @PatchMapping("{id}")
    public void updateUser(@PathVariable String id, @RequestBody UserInfoDto userInfoDto) throws Exception {
        userService.updateUser(id, userInfoDto);
    }
}
