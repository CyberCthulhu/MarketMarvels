package com.example.MarketMarvels.controller;

// Import the CustomerRepository
import com.example.MarketMarvels.repository.CustomerRepository;
import com.example.MarketMarvels.model.Customer; // Import the Customer model

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RestController // Marks this class as a Spring MVC controller where every method returns a domain object instead of a view
@RequestMapping("/api/users") // Maps HTTP requests to /api/users to this controller
public class CustomerController {

    @Autowired // Injects the CustomerRepository dependency
    private CustomerRepository customerRepository;

    @GetMapping
    public List<Customer> getAllUsers() {
        return customerRepository.findAll();
    }
}
