package com.example.demo.service;

import com.example.demo.model.entity.Brand;
import jdk.dynalink.linker.LinkerServices;

import java.util.List;

public interface BrandService {
    List<Brand> getAllBrands();
}
