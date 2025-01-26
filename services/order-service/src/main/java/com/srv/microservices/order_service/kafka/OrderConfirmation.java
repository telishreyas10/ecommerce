package com.srv.microservices.order_service.kafka;

import com.srv.microservices.order_service.dto.CustomerResponse;
import com.srv.microservices.order_service.dto.PurchaseResponse;
import com.srv.microservices.order_service.model.PaymentMethod;

import java.math.BigDecimal;
import java.util.List;

public record OrderConfirmation(
        String orderReference,
        BigDecimal amount,
        PaymentMethod paymentMethod,
        CustomerResponse customer,
        List<PurchaseResponse> products
) {
}
