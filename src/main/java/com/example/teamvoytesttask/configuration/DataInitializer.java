package com.example.teamvoytesttask.configuration;

import com.example.teamvoytesttask.model.Role;
import com.example.teamvoytesttask.model.User;
import com.example.teamvoytesttask.service.RoleService;
import com.example.teamvoytesttask.service.UserService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Set;

@Component
public class DataInitializer {
    private final UserService userService;
    private final RoleService roleService;

    public DataInitializer(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    void injectData() {
        Role clientRole = new Role();
        clientRole.setName(Role.RoleName.CLIENT);
        roleService.add(clientRole);
        Role managerRole = new Role();
        managerRole.setName(Role.RoleName.MANAGER);
        roleService.add(managerRole);
        User user = new User();
        user.setEmail("best_manager333@gmail.com");
        user.setPassword("qwerty123321");
        user.setRoles(Set.of(managerRole));
        userService.add(user);
    }

}
