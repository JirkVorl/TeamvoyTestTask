package com.example.teamvoytesttask.service;

import static org.springframework.security.core.userdetails.User.withUsername;

import com.example.teamvoytesttask.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UserService userService;

    public CustomUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userOptional = userService.findByEmail(username);
        if(userOptional.isPresent()) {
            User user = userOptional.get();
            UserBuilder builder = withUsername(username);
            builder.password(user.getPassword());
            builder.roles(user.getRoles().stream()
                    .map(role -> role.getName().name())
                    .toArray(String[]::new));
            return builder.build();
        }
        throw new RuntimeException("User with email " + username + " was not found");
    }
}
