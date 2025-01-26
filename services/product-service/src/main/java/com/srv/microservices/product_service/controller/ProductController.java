package com.srv.microservices.product_service.controller;

import com.srv.microservices.product_service.dto.ProductPurchaseRequest;
import com.srv.microservices.product_service.dto.ProductPurchaseResponse;
import com.srv.microservices.product_service.dto.ProductRequest;
import com.srv.microservices.product_service.dto.ProductResponse;
import com.srv.microservices.product_service.model.Product;
import com.srv.microservices.product_service.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Integer createProduct(@RequestBody @Valid ProductRequest productRequest) {
        return productService.createProduct(productRequest);
    }

    @PostMapping("/purchase")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductPurchaseResponse> purchaseProduct(@RequestBody List<ProductPurchaseRequest> productPurchaseRequest) {
        return productService.purchaseProduct(productPurchaseRequest);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProductResponse getProductById(@PathVariable Integer id) {
        return productService.getProductById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllProducts() {
        return productService.getAllProducts();
    }
}
