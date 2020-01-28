package com.chaapu.springstarter.customer;

import com.chaapu.springstarter.exceptions.ResourceAlreadyExistsException;
import com.chaapu.springstarter.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Optional;

@Service class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    CustomerList getAllCustomers(Optional<CustomerType> type, Pageable pageable) {

        ArrayList<Customer> customers = new ArrayList<>();
        if (type.isPresent()) {
            customers.addAll(customerRepository.findByType(type.get(), pageable));
        } else {
            customerRepository.findAll(pageable).forEach(customers::add);
        }

        return new CustomerList(customers);
    }

    Customer getCustomer(int id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Customer with ID %d not found", id)));
    }

    ResponseEntity addCustomer(Customer customer) throws URISyntaxException {
        verifyThatCustomerDoesNotAlreadyExist(customer.getId());
        customerRepository.save(customer);
        return ResponseEntity
                .created(new URI("/customers/" + customer.getId()))
                .build();
    }

    private void verifyThatCustomerDoesNotAlreadyExist(int customerId) {
        if (customerRepository.existsById(customerId)) {
            throw new ResourceAlreadyExistsException(
                    String.format("Cannot create customer with ID %d as it already exists", customerId));
        }
    }

    ResponseEntity<Customer> updateCustomer(Customer customer) {
        verifyThatCustomerExists(customer.getId());
        customerRepository.save(customer);
        return ResponseEntity
                .ok()
                .body(customer);
    }

    void deleteCustomer(int customerId) {
        verifyThatCustomerExists(customerId);
        customerRepository.deleteById(customerId);
    }

    private void verifyThatCustomerExists(int customerId) {
        if (!customerRepository.existsById(customerId)) {
            throw new ResourceNotFoundException(String.format("Customer with ID %d not found", customerId));
        }
    }
}
