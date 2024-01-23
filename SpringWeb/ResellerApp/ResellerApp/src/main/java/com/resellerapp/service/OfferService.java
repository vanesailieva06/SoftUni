package com.resellerapp.service;

import com.resellerapp.model.dto.AddOfferDto;
import com.resellerapp.model.entity.Offer;
import com.resellerapp.model.view.OfferViewModel;

import java.util.List;

public interface OfferService {
    void addOffer(AddOfferDto addOfferDto);

    List<OfferViewModel> getAllOffers();

}
