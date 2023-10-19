package com.example.shoppinglist.web;

import com.example.shoppinglist.model.view.ProductViewModel;
import com.example.shoppinglist.service.ProductService;
import com.example.shoppinglist.util.CurrentUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HomeController {
    private final ProductService productService;
    private final CurrentUser currentUser;

    public HomeController(ProductService productService, CurrentUser currentUser) {
        this.productService = productService;
        this.currentUser = currentUser;
    }

    @GetMapping("/")
    public String index(Model model){
        if (currentUser.getId() == null) {
            return "index";
        }
        List<ProductViewModel> products = this.productService.getProducts();

        model.addAttribute("foods", products.stream().
                filter(productViewModel ->
                        productViewModel.getCategory().getName().name().equals("Food"))
                .collect(Collectors.toList()));
        model.addAttribute("drinks", products.stream().
                filter(productViewModel ->
                        productViewModel.getCategory().getName().name().equals("Drink"))
                .collect(Collectors.toList()));

        model.addAttribute("households", products.stream().
                filter(productViewModel ->
                        productViewModel.getCategory().getName().name().equals("Household"))
                .collect(Collectors.toList()));
        model.addAttribute("others", products.stream().
                filter(productViewModel ->
                        productViewModel.getCategory().getName().name().equals("Other"))
                .collect(Collectors.toList()));

        model.addAttribute("totalPrice",
                products.stream()
                        .map(ProductViewModel::getPrice)
                        .reduce(BigDecimal::add)
                        .orElse(BigDecimal.valueOf(0))
        );

        return "home";
    }


    @GetMapping("/products/buy/{id}")
    public String buy(@PathVariable Long id){
        productService.buyProduct(id);
        return "redirect:/";
    }
    @GetMapping("/products/buy-all")
    public String buy(){
        productService.buyAll();
        return "redirect:/";
    }
}
