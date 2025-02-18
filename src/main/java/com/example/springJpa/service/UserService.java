package com.example.springJpa.service;


import com.example.springJpa.dao.entity.UserDetails;
import com.example.springJpa.dao.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<UserDetails> getAllUsers(){
        List<UserDetails> users = userRepository.findAll();
        System.out.println(users.toString());
        return users;
    }
}
