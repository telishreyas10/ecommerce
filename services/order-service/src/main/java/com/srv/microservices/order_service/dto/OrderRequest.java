package com.srv.microservices.order_service.dto;

import com.srv.microservices.order_service.model.PaymentMethod;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.util.List;

public record OrderRequest(

        Integer id,
        String reference,
        @Positive(message = "Order amount must be positive")
        BigDecimal amount,
        @NotNull(message = "Payment method must not be null")
        PaymentMethod paymentMethod,
        @NotNull(message = "Customer cannot be null")
        @NotEmpty(message = "Customer cannot be empty")
        @NotBlank(message = "Customer cannot be blank")
        String customerId,
        @NotEmpty(message = "Select at least one product")
        List<PurchaseRequest> products
) {
}
