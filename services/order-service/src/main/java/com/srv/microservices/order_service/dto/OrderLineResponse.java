package com.srv.microservices.order_service.dto;

public record OrderLineResponse(
        Integer id,
        double quantity
) {
}
