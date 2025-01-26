package com.srv.microservices.payment_service.service;

import com.srv.microservices.payment_service.dto.PaymentRequest;
import com.srv.microservices.payment_service.kafka.PaymentConfirmation;
import com.srv.microservices.payment_service.kafka.PaymentNotificationProducer;
import com.srv.microservices.payment_service.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {
    private final PaymentRepository paymentRepository;
    private final PaymentMapper paymentMapper;
    private final PaymentNotificationProducer paymentNotificationProducer;


    public Integer createPayment(PaymentRequest paymentRequest) {
        var payment = paymentRepository.save(paymentMapper.toPayment(paymentRequest));
        paymentNotificationProducer.sendNotification(
                new PaymentConfirmation(
                        paymentRequest.orderReference(),
                        paymentRequest.amount(),
                        paymentRequest.paymentMethod(),
                        paymentRequest.customer().firstName(),
                        paymentRequest.customer().lastName(),
                        paymentRequest.customer().email()
                )
        );
        return payment.getId();
    }
}
