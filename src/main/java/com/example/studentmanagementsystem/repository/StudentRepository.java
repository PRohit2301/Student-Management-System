package com.example.studentmanagementsystem.repository;

import com.example.studentmanagementsystem.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    // Find a student by linked user ID
    Optional<Student> findByUserId(Long userId);

    // Check if email already exists
    boolean existsByEmail(String email);
}


