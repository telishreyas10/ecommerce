# E-Commerce Microservices Application

## Overview

This project implements a **full-stack e-commerce application** using a **microservices architecture** with **Spring Boot**, **Spring Cloud**, and **Keycloak**. The application is designed to be scalable, resilient, and secure, enabling seamless interaction between customers, products, orders, payments, and notifications. It supports both synchronous and asynchronous communication and features distributed tracing and email notifications.

---

## Features

- **Microservices**:
  - **Customer Service**: Manages customer details.
  - **Product Service**: Handles product catalog and inventory.
  - **Order Service**: Manages order processing and integration with other services.
  - **Payment Service**: Processes payments and triggers notifications.
  - **Notification Service**: Sends order and payment confirmation emails.
- **Architecture**:
  - API Gateway as a single entry point for requests.
  - Kafka for asynchronous communication.
  - Eureka Discovery Server for service registration.
  - Config Server for centralized configuration.
- **Monitoring**:
  - Zipkin for distributed tracing.
  - Future support for ELK stack (Elasticsearch, Logstash, Kibana) for logging and analytics.
- **Security**:
  - Keycloak for authentication and authorization using OAuth2 and JWT tokens.

---

## Architecture

![Architecture](https://github.com/telishreyas10/ecommerce/blob/main/resources/architecture.png)

### Key Components

1. **API Gateway**: Routes requests to services and validates security tokens.
2. **Customer Service**: Manages customer data using MongoDB.
3. **Product Service**: Stores product details in PostgreSQL and handles inventory checks.
4. **Order Service**: Processes orders and communicates with customer, product, and payment services.
5. **Payment Service**: Handles payment processing and integrates with Kafka for notification events.
6. **Notification Service**: Consumes Kafka messages to send email confirmations.
7. **Support Services**:
   - **Config Server**: Centralized configuration.
   - **Eureka Discovery Server**: Service discovery and registration.
   - **Kafka**: Asynchronous messaging for reliable communication.
   - **Zipkin**: Distributed tracing for debugging.

---

## Tech Stack

- **Backend**: Spring Boot, Spring Cloud
- **Database**: MongoDB (Customer, Notification), PostgreSQL (Product, Order, Payment)
- **Asynchronous Messaging**: Apache Kafka
- **Security**: Keycloak, OAuth2
- **Distributed Tracing**: Zipkin
- **Containerization**: Docker

---

## Project Workflow

1. **Setup and Configuration**:
   - Docker Compose for services like PostgreSQL, MongoDB, Maildev, zipkin, and Kafka.
   - Config Server for centralized microservice configurations.
   - Eureka Discovery Server for service registration.

2. **Microservice Communication**:
   - **Synchronous**: HTTP (RestTemplate, OpenFeign) for real-time interactions.
   - **Asynchronous**: Kafka for reliable message-based communication.

3. **Distributed Tracing**:
   - Zipkin tracks the flow of requests across services.
   - Full visibility into latency and performance bottlenecks.

4. **Security**:
   - Keycloak secures API Gateway and microservices with OAuth2.
   - Realm and client setup for token-based authentication.

5. **Email Notifications**:
   - Notification service consumes Kafka messages and sends email confirmations.