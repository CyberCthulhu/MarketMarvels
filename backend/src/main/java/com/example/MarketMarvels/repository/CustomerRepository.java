package com.example.MarketMarvels.repository;

import com.example.MarketMarvels.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findByFirstName(String firstName);

    List<Customer>findByid(int id);
}
