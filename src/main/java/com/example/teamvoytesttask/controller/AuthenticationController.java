package com.example.teamvoytesttask.controller;

import com.example.teamvoytesttask.dto.request.UserRequestDto;
import com.example.teamvoytesttask.dto.response.UserResponseDto;
import com.example.teamvoytesttask.model.User;
import com.example.teamvoytesttask.service.AuthenticationService;
import com.example.teamvoytesttask.service.mapper.ResponseMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    private final ResponseMapper<UserResponseDto, User> mapper;

    public AuthenticationController(AuthenticationService authenticationService,
                                    ResponseMapper<UserResponseDto, User> mapper) {
        this.authenticationService = authenticationService;
        this.mapper = mapper;
    }
    @PostMapping("/register")
    public UserResponseDto register(@RequestBody UserRequestDto requestDto) {
        User user = authenticationService
                .register(requestDto.getEmail(), requestDto.getPassword());
        return mapper.mapToDto(user);
    }
}
