package com.srv.microservices.order_service.service;

import com.srv.microservices.order_service.dto.OrderLineRequest;
import com.srv.microservices.order_service.dto.OrderLineResponse;
import com.srv.microservices.order_service.model.Order;
import com.srv.microservices.order_service.model.OrderLine;
import org.springframework.stereotype.Service;

@Service
public class OrderLineMapper {

    public OrderLine toOrderLine(OrderLineRequest orderLinerRequest) {
        return OrderLine.builder()
                .id(orderLinerRequest.id())
                .quantity(orderLinerRequest.quantity())
                .order(Order.builder()
                        .id(orderLinerRequest.orderId())
                        .build())
                .productId(orderLinerRequest.productId())
                .build();
    }

    public OrderLineResponse toOrderLineResponse(OrderLine orderLine) {
        return new OrderLineResponse(orderLine.getId(), orderLine.getQuantity());
    }
}
