package com.example.demo.web;

import com.example.demo.model.dto.OfferAddDto;
import com.example.demo.service.BrandService;
import com.example.demo.service.OfferService;
import jakarta.validation.Valid;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/offers")
public class OfferController {

    private final OfferService offerService;
    private final BrandService brandService;

    public OfferController(OfferService offerService, BrandService brandService) {
        this.offerService = offerService;
        this.brandService = brandService;
    }

    @GetMapping("/add")
    public String add(Model model) {

        model.addAttribute("brands", brandService.getAllBrands());
        return "offer-add";
    }
    @PostMapping("/add")
    public String confirmAdd(@Valid OfferAddDto offerAddDto,
                             BindingResult bindingResult, RedirectAttributes redirectAttributes
    , @AuthenticationPrincipal UserDetails seller){
        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("offerAddDto", offerAddDto)
                    .addFlashAttribute("org.springframework.validation.BindingResult.offerAddDto",
                            bindingResult);
            return "redirect:/offers/add";
        }
        offerService.addOffer(offerAddDto, seller);

        return "redirect:/";
    }
    @ModelAttribute
    public OfferAddDto offerAddDto(){
        return new OfferAddDto();
    }
    @GetMapping("/all")
    public String all(Model model){
        model.addAttribute("offers", offerService.getAllOffers());
        return "offers";
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable Long id, Model model){
        model.addAttribute("offerViewDto", offerService.findById(id));
        return "details";
    }
}
