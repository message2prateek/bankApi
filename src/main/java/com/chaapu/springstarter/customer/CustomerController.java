package com.chaapu.springstarter.customer;

import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URISyntaxException;
import java.util.Optional;

@Api(tags = "Customer", description = "CRUD Operations for Bank Customers")
@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping(value = "/customers", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @ResponseStatus(value = HttpStatus.OK)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK") })
    @ApiOperation(value = "Get all the customer instances")
    public CustomerList getAllCustomers(@RequestParam Optional<CustomerType> customerType, Pageable pageable) {
        return customerService.getAllCustomers(customerType, pageable);
    }

    @GetMapping(value = "/customers/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @ResponseStatus(value = HttpStatus.OK)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 404, message = "Not Found") })
    @ApiOperation(value = "Find customer instance identified by ID")
    public Customer getCustomer(@PathVariable int id) {
        return customerService.getCustomer(id);
    }

    @PostMapping(value = "/customers", consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @ResponseStatus(value = HttpStatus.CREATED)
    @ApiResponses(value = { @ApiResponse(code = 201, message = "Created"), @ApiResponse(code = 409, message = "Conflict") })
    @ApiOperation(value = "Create a new Customer instance")
    public ResponseEntity addCustomer(@RequestBody @Valid @ApiParam(value = "Customer details", required = true, type = "body")Customer customer) throws URISyntaxException {
        return customerService.addCustomer(customer);
    }

    @PutMapping(value = "/customers/{id}", consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @ResponseStatus(value = HttpStatus.OK)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 404, message = "Customer not found") })
    @ApiOperation(value = "Update Customer identified by ID")
    public ResponseEntity<Customer> updateCustomer(@PathVariable int id, @RequestBody @Valid Customer customer) {
        customer.setId(id);
        return customerService.updateCustomer(customer);
    }

    @DeleteMapping(value = "/customers/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 404, message = "Not Found") })
    @ApiOperation(value = "Delete an existing Customer identified by ID")
    public void deleteCustomer(@PathVariable int id) {
        customerService.deleteCustomer(id);
    }
}
