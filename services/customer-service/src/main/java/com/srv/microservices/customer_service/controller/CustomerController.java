package com.srv.microservices.customer_service.controller;

import com.srv.microservices.customer_service.dto.CustomerRequest;
import com.srv.microservices.customer_service.dto.CustomerResponse;
import com.srv.microservices.customer_service.model.Customer;
import com.srv.microservices.customer_service.service.CustomerService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String createCustomer(@RequestBody @Valid CustomerRequest customerRequest) {
        return customerService.createCustomer(customerRequest);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public String updateCustomer(@RequestBody @Valid CustomerRequest customerRequest) {
        return customerService.updateCustomer(customerRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CustomerResponse> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerResponse getCustomerById(@PathVariable String id) {
        return customerService.getCustomerById(id);
    }

    @GetMapping ("/exist/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Boolean isCustomerExist(@PathVariable String id) {
        return customerService.isCustomerExist(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteCustomer(@PathVariable String id) {
        customerService.deleteCustomer(id);
    }
}
