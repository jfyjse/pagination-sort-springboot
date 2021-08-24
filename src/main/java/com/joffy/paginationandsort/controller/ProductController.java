package com.joffy.paginationandsort.controller;

import com.joffy.paginationandsort.entity.ProductEntity;
import com.joffy.paginationandsort.model.response.APIResponse;
import com.joffy.paginationandsort.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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

    @GetMapping("/pagination/{offset}/{pageSize}")
    private APIResponse<Page<ProductEntity>> getProductsWithPagination(@PathVariable int offset, @PathVariable int pageSize) {
        Page<ProductEntity> allProducts = productService.findProductPagination(offset, pageSize);
        return new APIResponse<>(allProducts.getSize(), allProducts);
    }

    @GetMapping("/paginationAndSort/{offset}/{pageSize}/{input}")
    private APIResponse<Page<ProductEntity>> getProductsWithSortPagination(@PathVariable int offset, @PathVariable int pageSize, @PathVariable String input) {
        Page<ProductEntity> allProducts = productService.findProductPaginationSort(offset, pageSize, input);
        return new APIResponse<>(allProducts.getSize(), allProducts);
    }
}
