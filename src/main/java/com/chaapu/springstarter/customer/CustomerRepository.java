package com.chaapu.springstarter.customer;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

interface CustomerRepository extends JpaRepository<Customer, Integer> {
    public List<Customer> findByType(CustomerType type, Pageable pageable);
    public Optional<Customer> findById(int id);
    public Page<Customer> findAll(Pageable pageable);
}
