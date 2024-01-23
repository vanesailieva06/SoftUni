package com.example.demo.service.impl;

import com.example.demo.model.dto.OfferAddDto;
import com.example.demo.model.entity.Offer;
import com.example.demo.repository.OfferRepository;
import com.example.demo.service.ModelService;
import com.example.demo.service.OfferService;
import com.example.demo.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class OfferServiceImpl implements OfferService {
    private final OfferRepository offerRepository;
    private final ModelMapper modelMapper;
    private final ModelService modelService;
    private final UserService userService;

    public OfferServiceImpl(OfferRepository offerRepository, ModelMapper modelMapper, ModelService modelService, UserService userService) {
        this.offerRepository = offerRepository;
        this.modelMapper = modelMapper;
        this.modelService = modelService;
        this.userService = userService;
    }

    @Override
    public void addOffer(OfferAddDto offerAddDto, UserDetails seller) {
        Offer offer = modelMapper.map(offerAddDto, Offer.class);
        offer.setCreated(LocalDateTime.now());
        offer.setModified(LocalDateTime.now());
        offer.setModel(modelService.findByName(offerAddDto.getModel()));
        offer.setSeller(userService.findByUsername(seller.getUsername()));
        offerRepository.save(offer);
    }
}
