package com.example.teamvoytesttask.service;

import com.example.teamvoytesttask.model.User;

public interface AuthenticationService {
    User register(String email, String password);
}
