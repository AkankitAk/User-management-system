package com.example.Usermanagementsystem.controller;

import com.example.Usermanagementsystem.model.User;
import com.example.Usermanagementsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class UserController {
    @Autowired
    UserService service;

    @PostMapping("/addUser")
    public String addUser(@RequestBody User user) {
        String status = service.addUser(user);
        return status;
    }

    @GetMapping("/getUser/{userId}")
    public String getUser(@PathVariable String userId) {

        return service.getUser(Integer.valueOf(userId)).toString();

    }
    @GetMapping("/getAllUser")
    public Map<Integer,User> getAllUser(){
        return service.getAllUser();
    }

    @PutMapping("/updateUserInfo/{userId}")
    public String updateUserInfo(@RequestBody User user, @PathVariable String userId) {

        return service.updateUser(user, Integer.valueOf(userId));
    }
    @DeleteMapping("/deleteUser/{userId}")
    public String deleteUserById(@PathVariable Integer userId) {

        return service.deleteUser(userId);

    }
}
