package com.example.demo.service.impl;

import com.example.demo.model.entity.User;
import com.example.demo.model.entity.UserRole;
import com.example.demo.repository.UserRepository;
import com.example.demo.util.CurrentUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class MobileleUserDetailsService implements UserDetailsService {
    private final CurrentUser currentUser;
    private final UserRepository userRepository;

    public MobileleUserDetailsService(CurrentUser currentUser, UserRepository userRepository) {
        this.currentUser = currentUser;
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository
                .findByUsername(username)
                .map(MobileleUserDetailsService::map)
                .orElseThrow(() -> new UsernameNotFoundException("User " + username + " not found!"));
    }

    private static UserDetails map(User userEntity) {
        return org.springframework.security.core.userdetails.User
                .withUsername(userEntity.getUsername())
                .password(userEntity.getPassword())
                .authorities(userEntity.getUserRole().stream().map(MobileleUserDetailsService::map).toList())
                .build();
    }

    private static GrantedAuthority map(UserRole userRoleEntity) {
        return new SimpleGrantedAuthority(
                "ROLE_" + userRoleEntity.getRole().name()
        );
    }
}
