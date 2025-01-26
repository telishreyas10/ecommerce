package com.srv.microservices.notification_service.model;

import java.math.BigDecimal;

public record Product(
        Integer id,
        String name,
        String description,
        BigDecimal price,
        double quantity
) {
}
