package com.user.controller;

import com.user.entity.UserEntity;
import com.user.enums.Status;
import com.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public UserEntity createUser(@RequestBody UserEntity userEntity) {
        return userService.createUser(userEntity);
    }

    @GetMapping("/id/{id}")
    public UserEntity getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @GetMapping("/name/{name}")
    public List<UserEntity> getUserByName(@PathVariable String name) {
        return userService.getUserByName(name);
    }

    @PutMapping("/{id}")
    public Status updateUserDetails(@PathVariable Long id, @RequestBody UserEntity userEntity) {
        return userService.updateUserDetails(id, userEntity);
    }

    @DeleteMapping("/{id}")
    public Status deleteUserById(@PathVariable Long id) {
        return userService.deleteUserDetails(id);
    }

}
