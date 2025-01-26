package com.srv.microservices.product_service.dto;

import com.srv.microservices.product_service.model.Category;

import java.math.BigDecimal;

public record ProductResponse(
        Integer id,
        String name,
        String description,
        BigDecimal price,
        double quantity,
        Category category
) {
}
