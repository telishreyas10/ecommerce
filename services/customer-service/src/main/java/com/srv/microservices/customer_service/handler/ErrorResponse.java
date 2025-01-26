package com.srv.microservices.customer_service.handler;

import java.util.Map;

public record ErrorResponse(
        Map<String , String> errors
) {
}
