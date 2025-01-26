package com.srv.microservices.order_service.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaOrderTopicConfig {

    public NewTopic orderTopic() {
        return TopicBuilder.name("order_topic").build();
    }
}
