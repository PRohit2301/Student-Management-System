package com.example.studentmanagementsystem.repository;

import com.example.studentmanagementsystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Find a user by username (used in login)
    Optional<User> findByUsername(String username);

    // Check if a username already exists
    boolean existsByUsername(String username);
}


