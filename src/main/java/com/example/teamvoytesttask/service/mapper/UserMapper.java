package com.example.teamvoytesttask.service.mapper;

import com.example.teamvoytesttask.dto.response.UserResponseDto;
import com.example.teamvoytesttask.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper implements ResponseMapper<UserResponseDto, User>{
    @Override
    public UserResponseDto mapToDto(User user) {
        UserResponseDto dto = new UserResponseDto();
        dto.setId(user.getId());
        dto.setEmail(user.getEmail());
        return dto;
    }
}
