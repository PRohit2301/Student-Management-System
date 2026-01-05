package com.example.studentmanagementsystem.service;

import com.example.studentmanagementsystem.model.User;

public interface UserService {

    // Authenticate user by username and password
    User login(String username, String password);
}
