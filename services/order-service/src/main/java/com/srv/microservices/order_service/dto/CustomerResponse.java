package com.srv.microservices.order_service.dto;

public record CustomerResponse(
        String id,
        String firstName,
        String lastName,
        String email
) {
}
