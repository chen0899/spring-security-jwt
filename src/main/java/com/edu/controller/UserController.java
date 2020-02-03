package com.edu.controller;

import com.edu.dto.UserDto;
import com.edu.model.User;
import com.edu.service.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public List<User> listUser(){
        return userService.findAll();
    }

    @GetMapping(value = "/{id}")
    @PreAuthorize("hasRole('USER')")
    public User getOne(@PathVariable(value = "id") Long id){
        return userService.findById(id);
    }

    @PostMapping(value="/signup")
    public User saveUser(@RequestBody UserDto user){
        return userService.save(user);
    }



}
