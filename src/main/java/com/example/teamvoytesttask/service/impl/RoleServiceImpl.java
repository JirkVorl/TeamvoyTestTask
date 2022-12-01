package com.example.teamvoytesttask.service.impl;

import com.example.teamvoytesttask.model.Role;
import com.example.teamvoytesttask.repository.RoleRepository;
import com.example.teamvoytesttask.service.RoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role add(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role getByName(String roleName) {
        return roleRepository.findByName(roleName).orElseThrow(
                () -> new RuntimeException("Role with name " + roleName + " not found")
        );
    }
}
