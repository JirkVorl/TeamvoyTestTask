package com.example.teamvoytesttask.service.impl;

import com.example.teamvoytesttask.model.User;
import com.example.teamvoytesttask.service.AuthenticationService;
import com.example.teamvoytesttask.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserService userService;

    public AuthenticationServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public User register(String email, String password) {
        return null;
    }
}
