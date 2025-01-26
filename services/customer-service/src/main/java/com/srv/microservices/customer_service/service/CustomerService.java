package com.srv.microservices.customer_service.service;

import com.srv.microservices.customer_service.dto.CustomerRequest;
import com.srv.microservices.customer_service.dto.CustomerResponse;
import com.srv.microservices.customer_service.exceptions.CustomerNotFoundException;
import com.srv.microservices.customer_service.model.Customer;
import com.srv.microservices.customer_service.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.lang.String.format;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public String createCustomer(CustomerRequest customerRequest) {
        return customerRepository.save(customerMapper.toCustomer(customerRequest)).getId();
    }

    public String updateCustomer(CustomerRequest customerRequest) {
        var customer = customerRepository.findById(customerRequest.id())
                .orElseThrow(() -> new CustomerNotFoundException(format("Customer with id %s not found", customerRequest.id())));
        mergeCustomer(customerRequest, customer);
        return customerRepository.save(customer).getId();
    }

    public List<CustomerResponse> getAllCustomers() {
        return customerRepository.findAll()
                .stream()
                .map(customerMapper::fromCustomer)
                .toList();
    }

    public CustomerResponse getCustomerById(String id) {
        return customerRepository.findById(id)
                .map(customerMapper::fromCustomer)
                .orElseThrow(() -> new CustomerNotFoundException(format("Customer with id %s not found", id)));
    }

    public Boolean isCustomerExist(String id) {
        return customerRepository.findById(id).isPresent();
    }

    public void deleteCustomer(String id) {
        customerRepository.deleteById(id);
    }

    public void mergeCustomer(CustomerRequest customerRequest, Customer customer) {
        if (StringUtils.isNotBlank(customerRequest.firstName())){
            customer.setFirstName(customerRequest.firstName());
        }
        if (StringUtils.isNotBlank(customerRequest.lastName())){
            customer.setLastName(customerRequest.lastName());
        }
        if (StringUtils.isNotBlank(customerRequest.email())){
            customer.setEmail(customerRequest.email());
        }
        if (customerRequest.address() != null){
            customer.setAddress(customerRequest.address());
        }
    }
}
