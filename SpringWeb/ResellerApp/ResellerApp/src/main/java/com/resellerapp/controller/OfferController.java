package com.resellerapp.controller;

import com.resellerapp.model.dto.AddOfferDto;
import com.resellerapp.service.OfferService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/offers")
public class OfferController {
    private final OfferService offerService;

    public OfferController(OfferService offerService) {
        this.offerService = offerService;
    }

    @GetMapping("/add")
    public String add(){
        return "offer-add";
    }

    @ModelAttribute
    public AddOfferDto addOfferDto(){
        return new AddOfferDto();
    }

    @PostMapping("/add")
    public String addOffer(@Valid AddOfferDto addOfferDto,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes){

        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("addOfferDto", addOfferDto)
                    .addFlashAttribute("org.springframework.validation.BindingResult.addOfferDtp",
                            bindingResult);
            return "redirect:add";
        }
        offerService.addOffer(addOfferDto);

        return "redirect:/";
    }
}
