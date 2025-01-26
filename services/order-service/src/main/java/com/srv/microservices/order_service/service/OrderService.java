package com.srv.microservices.order_service.service;

import com.srv.microservices.order_service.client.CustomerClient;
import com.srv.microservices.order_service.client.PaymentClient;
import com.srv.microservices.order_service.client.ProductClient;
import com.srv.microservices.order_service.dto.*;
import com.srv.microservices.order_service.kafka.OrderConfirmation;
import com.srv.microservices.order_service.exception.BusinessException;
import com.srv.microservices.order_service.kafka.OrderProducer;
import com.srv.microservices.order_service.repository.OrderRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final CustomerClient customerClient;
    private final ProductClient productClient;
    private final OrderMapper orderMapper;
    private final OrderLineService orderLineService;
    private final OrderProducer orderProducer;
    private final PaymentClient paymentClient;

    public Integer createOrder(OrderRequest orderRequest) {
        /* Check Customer - customer-service - openfeign */
        var customer = customerClient.getCustomerById(orderRequest.customerId())
                .orElseThrow(() -> new BusinessException("Cannot create order, Customer not found"));

        /* Purchase the product - product-service - Rest Template*/
        var purchasedProducts = productClient.purchaseProducts(orderRequest.products());

        /* Persist Order */
        var order = orderRepository.save(orderMapper.toOrder(orderRequest));

        /* Persist Orderline */
        for (PurchaseRequest purchaseRequest: orderRequest.products()){
            orderLineService.saveOrderLine(
                    new OrderLineRequest(
                            null,
                            order.getId(),
                            purchaseRequest.productId(),
                            purchaseRequest.quantity()
                    )
            );
        }

        /* Payment */
        var paymentRequest = new PaymentRequest(
                orderRequest.amount(),
                orderRequest.paymentMethod(),
                orderRequest.id(),
                orderRequest.reference(),
                customer
        );
        paymentClient.requestOrderPayment(paymentRequest);


        /* Send Order Coonfirmation to notification service via kafka */
        orderProducer.sendOrderConfirmation(
                new OrderConfirmation(
                        orderRequest.reference(),
                        orderRequest.amount(),
                        orderRequest.paymentMethod(),
                        customer,
                        purchasedProducts
                )
        );

        return order.getId();
    }

    public List<OrderResponse> getAllOrders() {
        return orderRepository.findAll()
                .stream()
                .map(orderMapper::toOrderResponse)
                .toList();
    }

    public OrderResponse getOrderById(Integer id) {
        return orderRepository.findById(id)
                .map(orderMapper::toOrderResponse)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Order with id %d not found", id)));
    }
}
