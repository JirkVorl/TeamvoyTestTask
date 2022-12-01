package com.example.teamvoytesttask.service.impl;

import com.example.teamvoytesttask.model.User;
import com.example.teamvoytesttask.repository.UserRepository;
import com.example.teamvoytesttask.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User add(User user) {
        return userRepository.save(user);
    }

    @Override
    public User get(Long id) {
        return userRepository.findById(id).orElseThrow(
                () -> new RuntimeException("User with id " + id + " not found"));
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
