package com.example.MarketMarvels.controller;

// Import the CustomerRepository


import com.example.MarketMarvels.repository.CustomerRepository;

import io.micrometer.core.ipc.http.HttpSender.Response;
import org.springframework.web.bind.annotation.RequestBody;


import com.example.MarketMarvels.model.Customer; // Import the Customer model

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.web.annotation.RestControllerEndpoint;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;



@CrossOrigin(origins = "*")// this allows javascript to fetch from the localhost
@RestController // Marks this class as a Spring MVC controller where every method returns a domain object instead of a view
@RequestMapping("/api") // Maps HTTP requests to /api/users to this controller
public class CustomerController {

    @Autowired // Injects the CustomerRepository dependency
    private CustomerRepository customerRepository;
    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping("/services")
    public List<Customer> getAllUsers() {
        
        List<Customer> customers = customerRepository.findAll();
        System.out.println(customers);
        return customers;
    }

    @GetMapping("/{id}")
    public List<Customer>getUsersByID(@PathVariable Long id){
        return customerRepository.findByid(id);
    }


    @GetMapping("/{department}")
    public List<Customer> getUsersByDepartment(@PathVariable String department) {
        return customerRepository.findByDepartment(department);
    }

    // add a put method to add a new service
    @PostMapping("/service")
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
        Customer newCustomer = customerRepository.save(customer);
        return ResponseEntity.ok(newCustomer);
    } 

    @DeleteMapping("/{id}")
    public ResponseEntity<HashMap<String, String>> deleteUser(@PathVariable Long id) {
        customerRepository.deleteById(id);
        HashMap<String, String> response = new HashMap<>();
        response.put("message", "Service deleted successfully");
        return ResponseEntity.ok(response);
    }
    

    // @GetMapping("/{firstName}")
    // public List<Customer> getUsersByFirstName(@PathVariable String name) {
    //     return customerRepository.findByName(name);
    // } 

    // @GetMapping("/{email}")
    // public List<Customer> getUsersByEmail(@PathVariable String contactInfo) {
    //     return customerRepository.findByContactInfo(contactInfo);
    // }




}


