package com.example.studentmanagementsystem.service.impl;

import com.example.studentmanagementsystem.model.User;
import com.example.studentmanagementsystem.repository.UserRepository;
import com.example.studentmanagementsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User login(String username, String password) {
        Optional<User> optionalUser = userRepository.findByUsername(username);
        if (optionalUser.isEmpty()) {
            throw new RuntimeException("Invalid username or password");
        }

        User user = optionalUser.get();

        // For now, passwords are plain text
        if (!user.getPassword().equals(password)) {
            throw new RuntimeException("Invalid username or password");
        }

        return user;
    }
}

