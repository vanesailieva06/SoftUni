package com.resellerapp.service;

import com.resellerapp.model.entity.Offer;
import com.resellerapp.model.entity.User;

import java.util.List;
import java.util.Set;

public interface UserService {
    User findByUsername(String username);

    void registerUser(User map);

    User findByUsernameAndPassword(String username, String password);

    void logout();

    User findById(Long id);

    Set<Offer> findOffersByCurrentId(Long id);

    Set<Offer> findOffersNotEqualToCurrentId(Long id);
}
