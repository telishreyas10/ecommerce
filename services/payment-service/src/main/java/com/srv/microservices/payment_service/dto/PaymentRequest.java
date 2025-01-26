package com.srv.microservices.payment_service.dto;

import com.srv.microservices.payment_service.model.Customer;
import com.srv.microservices.payment_service.model.PaymentMethod;

import java.math.BigDecimal;

public record PaymentRequest(
        Integer id,
        BigDecimal amount,
        PaymentMethod paymentMethod,
        Integer orderId,
        String orderReference,
        Customer customer
) {
}
