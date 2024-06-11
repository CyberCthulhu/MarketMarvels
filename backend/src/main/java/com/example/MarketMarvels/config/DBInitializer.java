package com.example.MarketMarvels.config;

import com.example.MarketMarvels.model.Customer;
import com.example.MarketMarvels.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration // Indicates that this class contains Spring configuration
public class DBInitializer {

    @Bean
    CommandLineRunner initDatabase(CustomerRepository customerRepository) {
        return args -> {
            // Create a list of sample customers
            var customers = List.of(
                    new Customer("John", "Doe", "john.doe@example.com"),
                    new Customer("Jane", "Smith", "jane.smith@example.com"),
                    new Customer("Michael", "Johnson", "michael.johnson@example.com")
            );
            // Save all customers to the database
            customerRepository.saveAll(customers);
        };
    }
}
