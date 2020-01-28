package com.chaapu.springstarter.account;

import com.chaapu.springstarter.customer.Customer;
import com.chaapu.springstarter.customer.CustomerType;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@Api(tags = "Account", description = "CRUD Operations for Accounts")
public class AccountController {

    @Autowired
    AccountService accountService;

    @GetMapping(value = "/customers/{customerId}/accounts")
    @ResponseStatus(value = HttpStatus.OK)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK") })
    @ApiOperation(value = "Get all account instances")
    public List<Account> getAllAccounts(@PathVariable int customerId,
            @RequestParam(name = "type", required = false) Optional<String> accountType, Pageable pageable) {
        return accountService.getAllAccounts(customerId, accountType, pageable);
    }

    @GetMapping(value = "/customers/{customerId}/accounts/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK") })
    @ApiOperation(value = "Get an account instance identified by ID")
    public Account getAccount(@PathVariable int id) {
        return accountService.getAccount(id);
    }

    @PostMapping(value = "/customers/{customerId}/accounts")
    @ResponseStatus(value = HttpStatus.CREATED)
    @ApiResponses(value = { @ApiResponse(code = 201, message = "Created") })
    @ApiOperation(value = "Create an new instance of an Account")
    public void addAccount(@PathVariable int customerId, @Valid @RequestBody Account account) {

        account.setCustomer(new Customer(customerId, "", CustomerType.Business));
        accountService.addAccount(account);
    }

    @PutMapping(value = "/customers/{customerId}/accounts/{id}")
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    @ApiResponses(value = { @ApiResponse(code = 202, message = "Accepted") })
    @ApiOperation(value = "Update an Account Identified by ID")
    public ResponseEntity<Object> updateAccount(@PathVariable int customerId, @PathVariable int id, @RequestBody @Valid Account account) {
        account.setCustomer(new Customer(customerId, "", CustomerType.Business));
        account.setId(id);  // to avoid defect when ID in the body and the path parameter for account number don't match.
        return accountService.updateAccount(account);
    }

    @DeleteMapping(value = "/customers/{customerId}/accounts/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK") })
    @ApiOperation(value = "Delete an Account identified by ID")
    public ResponseEntity deleteAccount(@PathVariable String customerId, @PathVariable int id) {
        return accountService.deleteAccount(id);
    }
}
