package com.example.carrental.service;

import com.example.carrental.model.User;
import com.example.carrental.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Register a new user
    public User registerUser(User user) {
        return userRepository.save(user);
    }

    // Find user by username
    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
