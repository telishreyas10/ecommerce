package com.srv.microservices.product_service.dto;

import jakarta.validation.constraints.NotNull;

public record ProductPurchaseRequest(
        @NotNull(message = "Product ID is mandatory")
        Integer productId,
        @NotNull(message = "Product Quantity is mandatory")
        double quantity
) {
}
