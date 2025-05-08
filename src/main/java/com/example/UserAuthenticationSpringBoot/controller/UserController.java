package com.example.UserAuthenticationSpringBoot.controller;

import com.example.UserAuthenticationSpringBoot.exceptionHandler.ResourceNotFoundException;
import com.example.UserAuthenticationSpringBoot.model.User;
import com.example.UserAuthenticationSpringBoot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id){
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found with id" + id));
    }

    //User user (dpt dari entity) > database utk save
    @PostMapping("/createUser")
    public User createUser(@RequestBody User user){
        //cara nk hide password
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    //ambik id dari User entity
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user){
        User userData = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found with id" + id));
        userData.setEmail(user.getEmail());
        userData.setName(user.getName());
        return userRepository.save(userData);
    }

    //ambik id then delete
    @DeleteMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Long id){
        User userData = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found with id" + id));
        userRepository.delete(userData);
        return ResponseEntity.ok().build();
    }
}
