package com.resellerapp.service.impl;

import com.resellerapp.model.dto.AddOfferDto;
import com.resellerapp.model.entity.Offer;
import com.resellerapp.model.view.OfferViewModel;
import com.resellerapp.repository.OfferRepository;
import com.resellerapp.service.ConditionService;
import com.resellerapp.service.OfferService;
import com.resellerapp.service.UserService;
import com.resellerapp.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OfferServiceImpl implements OfferService {
    private final OfferRepository offerRepository;
    private final ConditionService conditionService;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;
    private final UserService userService;


    public OfferServiceImpl(OfferRepository offerRepository, ConditionService conditionService, ModelMapper modelMapper, CurrentUser currentUser, UserService userService) {
        this.offerRepository = offerRepository;
        this.conditionService = conditionService;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
        this.userService = userService;
    }

    @Override
    public void addOffer(AddOfferDto addOfferDto) {
        Offer offer = modelMapper.map(addOfferDto, Offer.class);
        offer.setCondition(conditionService.findByEnumName(addOfferDto.getCondition()));
        offer.setUser(userService.findById(currentUser.getId()));
        offerRepository.save(offer);
    }

    @Override
    public List<OfferViewModel> getAllOffers() {
        return offerRepository.findAll()
                .stream().map(offer -> modelMapper.map(offer, OfferViewModel.class))
                .collect(Collectors.toList());
    }
}
