package com.example.spring_boot_demo.controller;

import com.example.spring_boot_demo.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    /*@GetMapping
    public String getUsers(){
        return "Hello API";
    }*/

    @GetMapping
    public List<User> getUsers(){
        return Arrays.asList(new User(1L, "John", "john@abc.com"),
                new User(1L, "Joe", "joe@abc.com"));
    }
}
