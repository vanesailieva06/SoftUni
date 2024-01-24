package com.example.demo.service.impl;

import com.example.demo.model.dto.OfferAddDto;
import com.example.demo.model.dto.OfferViewDto;
import com.example.demo.model.entity.Offer;
import com.example.demo.repository.OfferRepository;
import com.example.demo.service.ModelService;
import com.example.demo.service.OfferService;
import com.example.demo.service.UserService;
import org.hibernate.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public List<OfferAddDto> getAllOffers() {

        return offerRepository.findAll().stream().map(offer ->{
                    OfferAddDto map = modelMapper.map(offer, OfferAddDto.class);
                    map.setModel(offer.getModel().getName());
                    map.setBrand(offer.getModel().getBrand().getName());
                    return map;
                })
                .collect(Collectors.toList());
    }

    @Override
    public OfferViewDto findById(Long id) {
        Offer offer = offerRepository.findById(id).orElseThrow(() -> new NullPointerException("Offer with id " + id + " not found!"));
        OfferViewDto viewDto = modelMapper.map(offer, OfferViewDto.class);
        viewDto.setBrandName(offer.getModel().getBrand().getName());
        viewDto.setModelName(offer.getModel().getName());
        viewDto.setFullName(offer.getSeller().getFirstName() + " " + offer.getSeller().getLastName());

        return viewDto;

    }
}
