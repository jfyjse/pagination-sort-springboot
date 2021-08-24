package com.joffy.paginationandsort.controller;

import com.joffy.paginationandsort.entity.ProductEntity;
import com.joffy.paginationandsort.model.response.APIResponse;
import com.joffy.paginationandsort.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping
    private APIResponse<List<ProductEntity>> getProducts() {
        List<ProductEntity> allProducts = productService.findAllProducts();
        return new APIResponse<>(allProducts.size(), allProducts);
    }

    @GetMapping("/{input}")
    private APIResponse<List<ProductEntity>> getProductsWithSort(@PathVariable String input) {
        List<ProductEntity> allProducts = productService.findProductSort(input);
        return new APIResponse<>(allProducts.size(), allProducts);
    }

}
