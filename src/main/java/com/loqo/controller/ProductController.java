package com.loqo.controller;


import com.loqo.entity.Product;
import com.loqo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class ProductController {

    @Autowired
    ProductService productService;


    @PostMapping("/addProduct")
    public ResponseEntity<Product> saveProduct(@RequestBody Product product) {

        Product savedProduct = productService.addProduct(product);
        System.out.println("New product added :- "+savedProduct.toString());
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);

    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProducts(@RequestParam Optional<String> category, @RequestParam Optional<Double> minPrice, @RequestParam Optional<Double> maxPrice, @RequestParam Optional<Boolean> inStock, @RequestParam(defaultValue = "createdAt") String sortField, @RequestParam(defaultValue = "asc") String sortOrder) {

        List<Product> products = productService.getProducts(category, minPrice, maxPrice, inStock, sortField, sortOrder);
        System.out.println(products.toString());
        return new ResponseEntity<>(products, HttpStatus.OK);


    }


}
