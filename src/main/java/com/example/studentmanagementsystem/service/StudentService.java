package com.example.studentmanagementsystem.service;

import com.example.studentmanagementsystem.model.Student;
import java.util.List;

public interface StudentService {

    Student addStudent(Student student);        // Create
    Student updateStudent(Long id, Student student);  // Update
    void deleteStudent(Long id);               // Delete
    Student getStudentById(Long id);           // Read single
    List<Student> getAllStudents();

    // Read all

    Student getMyProfile(String username);
}

