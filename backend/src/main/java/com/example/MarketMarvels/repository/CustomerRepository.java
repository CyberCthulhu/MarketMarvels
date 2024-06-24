package com.example.MarketMarvels.repository;

import com.example.MarketMarvels.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findByName(String name);

    List<Customer>findByid(Long id);

    List<Customer>findByContactInfo(String contactInfo);

    List<Customer>findByDepartment(String department);

}
