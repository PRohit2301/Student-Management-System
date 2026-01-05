package com.example.studentmanagementsystem.controller;

import com.example.studentmanagementsystem.model.User;
import com.example.studentmanagementsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

   // @PostMapping("/login")
   // public User login(@RequestParam String username,
   //                   @RequestParam String password) {
   //     return userService.login(username, password);
    //}

    // Temporarily use GET for browser testing
    @GetMapping("/login")
    public User loginGet(@RequestParam String username,
                         @RequestParam String password) {
        return userService.login(username, password);
    }
}

