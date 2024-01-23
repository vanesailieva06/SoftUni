package com.example.demo.service.impl;

import com.example.demo.model.dto.UserRegisterDto;
import com.example.demo.model.entity.Role;
import com.example.demo.model.entity.User;
import com.example.demo.model.entity.UserRole;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.UserRoleRepository;
import com.example.demo.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final UserRoleRepository userRoleRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, UserRoleRepository userRoleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.userRoleRepository = userRoleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }

    @Override
    public void register(UserRegisterDto userRegisterDto) {
        User map = modelMapper.map(userRegisterDto, User.class);
        map.setPassword(passwordEncoder.encode(userRegisterDto.getPassword()));
        List<UserRole> roles = new ArrayList<>();

        for (Role role : userRegisterDto.getRole()) {
            UserRole userRole = new UserRole();
            userRole.setRole(role);
            userRoleRepository.save(userRole);
            roles.add(userRole);
        }
        map.setUserRole(roles);
        map.setActive(true);
        map.setCreated(LocalDateTime.now());
        map.setModified(LocalDateTime.now());
        userRepository.save(map);
    }
}
