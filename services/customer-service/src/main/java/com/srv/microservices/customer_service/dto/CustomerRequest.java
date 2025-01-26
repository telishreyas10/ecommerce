package com.srv.microservices.customer_service.dto;

import com.srv.microservices.customer_service.model.Address;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record CustomerRequest(
        String id,

        @NotNull (message = "Customer's first name is required")
        String firstName,

        @NotNull (message = "Customer's last name is required")
        String lastName,

        @NotNull (message = "Customer's email is required")
        @Email ( message = "Invalid email")
        String email,
        Address address
) {
}
