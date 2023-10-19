package com.example.shoppinglist.web;

import com.example.shoppinglist.model.dto.AddProductDto;
import com.example.shoppinglist.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/add")
    public String add(){
        return "product-add";
    }

    @PostMapping("/add")
    public String addProduct(@Valid AddProductDto addProductDto,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("addProductDto", addProductDto)
                    .addFlashAttribute("org.springframework.validation.BindingResult.addProductDto",
                            bindingResult);
            return "redirect:add";
        }
        productService.addProduct(addProductDto);

        return "redirect:/";
    }
    @ModelAttribute
    public AddProductDto addProductDto(){
        return new AddProductDto();
    }
}
