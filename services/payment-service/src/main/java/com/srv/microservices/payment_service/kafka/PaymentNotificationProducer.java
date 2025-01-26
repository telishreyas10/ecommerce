package com.srv.microservices.payment_service.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class PaymentNotificationProducer {
    private final KafkaTemplate<String, PaymentConfirmation> kafkaTemplate;

    public void sendNotification(PaymentConfirmation paymentConfirmation) {
        log.info("Sending notification to payment service: {}", paymentConfirmation);
        Message<PaymentConfirmation> message = MessageBuilder
                .withPayload(paymentConfirmation)
                .setHeader(KafkaHeaders.TOPIC, "payment_topic")
                .build();
        kafkaTemplate.send(message);
    }

}
