package com.srv.microservices.order_service.repository;

import com.srv.microservices.order_service.model.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderLineRepository extends JpaRepository<OrderLine, Long> {

    List<OrderLine> findAllByOrderId(Integer orderId);
}
