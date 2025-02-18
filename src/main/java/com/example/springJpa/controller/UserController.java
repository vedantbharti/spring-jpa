package com.example.springJpa.controller;


import com.example.springJpa.dao.entity.UserDetails;
import com.example.springJpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(value = "/users", produces = "application/json")
    public List<UserDetails> getUserDetails(){
        return userService.getAllUsers();
    }
}
