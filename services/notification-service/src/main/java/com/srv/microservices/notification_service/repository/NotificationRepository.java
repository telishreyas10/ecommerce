package com.srv.microservices.notification_service.repository;

import com.srv.microservices.notification_service.kafka.PaymentConfirmation;
import com.srv.microservices.notification_service.model.Notification;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NotificationRepository extends MongoRepository<Notification, String> {
}
