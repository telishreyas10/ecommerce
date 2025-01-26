package com.srv.microservices.order_service.controller;

import com.srv.microservices.order_service.dto.OrderLineResponse;
import com.srv.microservices.order_service.service.OrderLineService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/order-lines")
@RequiredArgsConstructor
public class OrderLineController {
    private final OrderLineService orderLineService;

    @GetMapping("/order/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<OrderLineResponse> getAllOrderLines(@PathVariable Integer id) {
        return orderLineService.getOrderLinesByOrderId(id);
    }
}
