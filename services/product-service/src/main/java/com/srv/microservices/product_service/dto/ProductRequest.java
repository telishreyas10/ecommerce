package com.srv.microservices.product_service.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record ProductRequest(
        Integer id,

        @NotNull(message = "Product Name is required")
        String name,

        @NotNull(message = "Product Description is required")
        String description,

        @Positive(message = "Price must be greater than 0")
        BigDecimal price,

        @Positive(message = "Quantity must be at least one")
        double quantity,

        @NotNull (message = "Product Category is required")
        Integer categoryId
) {
}
