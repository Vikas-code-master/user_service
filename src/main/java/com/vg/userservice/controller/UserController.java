package com.vg.userservice.controller;

import com.vg.userservice.enums.ApiResponse;
import com.vg.userservice.enums.ApiStatus;
import com.vg.userservice.model.User;
import com.vg.userservice.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@Validated
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/register", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<User> registerUser(@Valid @RequestBody User userRequest) {
        User user = userService.registerUser(userRequest);
        return new ApiResponse<>(ApiStatus.SUCCESS, user);
    }

    @GetMapping(value = "/get-profile", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<User> getProfile(@Valid @RequestParam String name) {
        User user = userService.getUserByName(name);
        return new ApiResponse<>(ApiStatus.SUCCESS, user);
    }
    @GetMapping(value = "/get-alluser", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<List<User>> alluser() {
        List<User> users = userService.getAllUser();
        return new ApiResponse<>(ApiStatus.SUCCESS, users);
    }
}

