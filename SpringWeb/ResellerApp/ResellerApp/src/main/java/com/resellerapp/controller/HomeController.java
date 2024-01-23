package com.resellerapp.controller;

import com.resellerapp.model.entity.Offer;
import com.resellerapp.model.entity.User;
import com.resellerapp.model.view.OfferViewModel;
import com.resellerapp.service.OfferService;
import com.resellerapp.service.UserService;
import com.resellerapp.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
public class HomeController {
    private final CurrentUser currentUser;
    private final OfferService offerService;
    private final ModelMapper modelMapper;
    private final UserService userService;

    public HomeController(CurrentUser currentUser, OfferService offerService, ModelMapper modelMapper, UserService userService) {
        this.currentUser = currentUser;
        this.offerService = offerService;
        this.modelMapper = modelMapper;
        this.userService = userService;
    }



    @GetMapping("/")
    public String index(Model model){
        if (currentUser.getId() == null){
            return "index";
        }

        List<OfferViewModel> allOffers = offerService.getAllOffers();
        Set<Offer> offersByCurrentId = userService.findOffersByCurrentId(currentUser.getId());
        Set<Offer> offersNotEqualToCurrentId = userService.findOffersNotEqualToCurrentId(currentUser.getId());


        model.addAttribute("myOffers", offersByCurrentId);
        model.addAttribute("loggedUser", userService.findById(currentUser.getId()));


        model.addAttribute("allOtherOffers", offersNotEqualToCurrentId);

        return "home";
    }
}
