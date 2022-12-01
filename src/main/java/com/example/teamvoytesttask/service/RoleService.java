package com.example.teamvoytesttask.service;

import com.example.teamvoytesttask.model.Role;

public interface RoleService {
    Role add(Role role);

    Role getByName(String roleName);
}
