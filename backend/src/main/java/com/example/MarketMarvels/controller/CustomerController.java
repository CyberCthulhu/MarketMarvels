package com.example.MarketMarvels.controller;

import com.example.MarketMarvels.model.Customer;
import com.example.MarketMarvels.repository.CustomerRepository;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*") // This allows JavaScript to fetch from the localhost
@RestController // Marks this class as a Spring MVC controller where every method returns a domain object instead of a view
@RequestMapping("/api/services") // Maps HTTP requests to /api/customers to this controller
public class CustomerController {

    @Autowired // Injects the CustomerRepository dependency
    private CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping("/")
    public List<Customer> getAllUsers() {
        List<Customer> customers = customerRepository.findAll();
        System.out.println(customers);
        return customers;
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Customer> getUserById(@PathVariable Long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        if (customer.isPresent()) {
            return ResponseEntity.ok(customer.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/department/{department}")
    public List<Customer> getUsersByDepartment(@PathVariable String department) {
        return customerRepository.findByDepartment(department);
    }

    @PostMapping("/service")
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
        Customer newCustomer = customerRepository.save(customer);
        return ResponseEntity.ok(newCustomer);
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<HashMap<String, String>> deleteUser(@PathVariable Long id) {
        customerRepository.deleteById(id);
        HashMap<String, String> response = new HashMap<>();
        response.put("message", "Service deleted successfully");
        return ResponseEntity.ok(response);
    }
}
