package com.chaapu.springstarter.account;

import com.chaapu.springstarter.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    List<Account> getAllAccounts(int customerId, Optional<String> accountType, Pageable pageable) {

        ArrayList<Account> accounts = new ArrayList<>();
        if (!accountType.isPresent()) {
            accounts.addAll(accountRepository.findByCustomerId(customerId, pageable).getContent());
        } else {
            accountRepository.findByCustomerIdAndTypeIgnoreCase(customerId, accountType.get(), pageable).forEach(accounts::add);
        }

        return accounts;

    }

    Account getAccount(int id) {
        return accountRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Account with ID %d not found", id)));
    }

    void addAccount(Account account) {
        accountRepository.save(account);
    }

    ResponseEntity updateAccount(Account account) {
        verifyThatAccountExists(account.getId());
        accountRepository.save(account);
        return ResponseEntity.ok().body(account);
    }

    ResponseEntity deleteAccount(int id) {
        verifyThatAccountExists(id);
        accountRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    private void verifyThatAccountExists(int accountId) {
        if (!accountRepository.existsById(accountId)) {
            throw new ResourceNotFoundException(String.format("Account with ID %d not found", accountId));
        }
    }
}
