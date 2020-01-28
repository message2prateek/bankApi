package com.chaapu.springstarter.account;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

interface AccountRepository extends JpaRepository<Account, Integer> {
    public Page<Account> findByCustomerId(int id, Pageable pageable);
    public Optional<Account> findById(int id);
    public List<Account> findByCustomerIdAndTypeIgnoreCase(int id, String type, Pageable pageable);
}
