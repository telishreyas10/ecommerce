package com.srv.microservices.notification_service.kafka;

import com.srv.microservices.notification_service.model.Customer;
import com.srv.microservices.notification_service.model.PaymentMethod;
import com.srv.microservices.notification_service.model.Product;

import java.math.BigDecimal;
import java.util.List;

public record OrderConfirmation(
        String orderReference,
        BigDecimal amount,
        PaymentMethod paymentMethod,
        Customer customer,
        List<Product> products
) {
}
