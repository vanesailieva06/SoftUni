package com.resellerapp.service.impl;

import com.resellerapp.model.entity.Offer;
import com.resellerapp.model.entity.User;
import com.resellerapp.repository.UserRepository;
import com.resellerapp.service.UserService;
import com.resellerapp.util.CurrentUser;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final CurrentUser currentUser;

    public UserServiceImpl(UserRepository userRepository, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.currentUser = currentUser;
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }

    @Override
    public void registerUser(User user) {
        userRepository.save(user);
    }

    @Override
    public User findByUsernameAndPassword(String username, String password) {
       return userRepository.findByUsernameAndPassword(username, password)
                .orElse(null);
    }

    @Override
    public void logout() {
        currentUser.setId(null);
        currentUser.setUsername(null);
    }

    @Override
    public User findById(Long id) {

        return userRepository.findById(id).orElse(null);
    }

    @Override
    public Set<Offer> findOffersByCurrentId(Long id) {
        User user = findById(id);
        return user.getOffers();
    }

    @Override
    public Set<Offer> findOffersNotEqualToCurrentId(Long id) {
        Set<Offer> offers = new LinkedHashSet<>();
        Set<User> users = userRepository.findAllByIdIsNot(id);

        for (User user : users) {
            offers.addAll(user.getOffers());
        }

        return offers;
    }
}
