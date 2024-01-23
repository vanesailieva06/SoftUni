package com.example.demo.service;

import com.example.demo.model.dto.OfferAddDto;
import org.springframework.security.core.userdetails.UserDetails;

public interface OfferService {
    void addOffer(OfferAddDto offerAddDto, UserDetails seller);
}
