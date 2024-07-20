package com.loqo.service;

import com.loqo.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    Product addProduct(Product product);
    List<Product> getProducts(Optional<String> category, Optional<Double> minPrice, Optional<Double> maxPrice, Optional<Boolean> inStock, String sortField, String sortOrder);

}
