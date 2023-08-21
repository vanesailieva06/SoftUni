package com.example.jsonProcessing.service.impl;

import com.example.jsonProcessing.model.dto.ProductSeedDto;
import com.example.jsonProcessing.model.entity.Product;
import com.example.jsonProcessing.repository.ProductRepository;
import com.example.jsonProcessing.service.CategoryService;
import com.example.jsonProcessing.service.ProductService;
import com.example.jsonProcessing.service.UserService;
import com.example.jsonProcessing.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

import static com.example.jsonProcessing.coinstraints.GlobalConstraints.FILES_PATH;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final Gson gson;
    private final CategoryService categoryService;
    private final UserService userService;
    private static final String PRODUCT_FILE_NAME = "products.json";

    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper, ValidationUtil validationUtil, Gson gson, CategoryService categoryService, UserService userService) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.gson = gson;
        this.categoryService = categoryService;
        this.userService = userService;
    }

    @Override
    public void seedProduct() throws IOException {
        if (productRepository.count() == 0){
            String content = Files.readString(Path.of(FILES_PATH + PRODUCT_FILE_NAME));

            ProductSeedDto[] productSeedDtos = gson.fromJson(content, ProductSeedDto[].class);

            Arrays.stream(productSeedDtos).filter(validationUtil::isValid)
                    .map(productSeedDto -> {
                        Product product = modelMapper.map(productSeedDto, Product.class);
                        product.setSeller(userService.getRandomUser());
                        if (product.getPrice().compareTo(BigDecimal.valueOf(1000L)) > 0){
                            product.setBuyer(userService.getRandomUser());
                        }
                        product.setCategories(categoryService.getRandomCategories());
                        return product;
                    })
                    .forEach(productRepository::save);
        }
    }
}
