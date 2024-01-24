package com.example.demo.service;

import com.example.demo.model.dto.OfferAddDto;
import com.example.demo.model.dto.OfferViewDto;
import com.example.demo.model.entity.Offer;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface OfferService {
    void addOffer(OfferAddDto offerAddDto, UserDetails seller);

    List<OfferAddDto> getAllOffers();

    OfferViewDto findById(Long id);
}
