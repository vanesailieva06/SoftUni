package com.example.pathfinder.service.impl;

import com.example.pathfinder.model.dto.UserLoginDto;
import com.example.pathfinder.model.dto.UserRegisterDto;
import com.example.pathfinder.model.entity.User;
import com.example.pathfinder.model.entity.enums.LevelEnum;
import com.example.pathfinder.repository.UserRepository;
import com.example.pathfinder.service.UserService;
import com.example.pathfinder.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
    }

    @Override
    public void userRegister(UserRegisterDto userRegisterDto) {
        User user = modelMapper.map(userRegisterDto, User.class);

        user.setLevel(LevelEnum.BEGINNER);

        userRepository.save(user);
    }

    @Override
    public UserLoginDto findByUsernameAndPassword(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password)
                .map(user -> modelMapper.map(user, UserLoginDto.class))
                .orElse(null);
    }

    @Override
    public void logout() {
        currentUser.setId(null);
        currentUser.setUsername(null);
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id)
                .orElse(null);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElse(null);
    }

    @Override
    public User findByID(Long id) {

        return userRepository.findById(id).orElse(null);
    }
}
