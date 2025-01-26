package com.srv.microservices.order_service.repository;

import com.srv.microservices.order_service.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
