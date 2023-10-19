package com.example.shoppinglist.service;

import com.example.shoppinglist.model.dto.AddProductDto;
import com.example.shoppinglist.model.entity.Product;
import com.example.shoppinglist.model.view.ProductViewModel;

import java.util.List;

public interface ProductService {
    void addProduct(AddProductDto addProductDto);

    List<ProductViewModel> getProducts();

    void buyProduct(Long id);

    void buyAll();

}
