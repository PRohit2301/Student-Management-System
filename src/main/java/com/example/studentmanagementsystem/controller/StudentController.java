package com.example.studentmanagementsystem.controller;

import com.example.studentmanagementsystem.model.Student;
import com.example.studentmanagementsystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    // STUDENT: View own profile only
    @GetMapping("/profile")
    public Student getMyProfile(Authentication authentication) {
        return studentService.getMyProfile(authentication.getName());
    }

    @GetMapping("/student-login")
    public String studentLogin() {
        return "student-login";
    }

}




