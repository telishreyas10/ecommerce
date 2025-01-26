package com.srv.microservices.payment_service.controller;

import com.srv.microservices.payment_service.dto.PaymentRequest;
import com.srv.microservices.payment_service.model.Payment;
import com.srv.microservices.payment_service.service.PaymentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/payments")
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentService paymentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Integer createPayment(@RequestBody @Valid PaymentRequest paymentRequest) {
        return paymentService.createPayment(paymentRequest);
    }
}
