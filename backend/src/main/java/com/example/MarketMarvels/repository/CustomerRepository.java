package com.example.MarketMarvels.repository;

import com.example.MarketMarvels.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
