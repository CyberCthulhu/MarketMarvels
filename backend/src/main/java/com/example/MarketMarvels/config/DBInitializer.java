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
                customerRepository.save(new Customer("GreenLeaf Landscaping", "Professional landscaping and garden maintenance services for residential and commercial properties, including lawn care, tree trimming, and flower bed design.", "Outdoor Services", "(217) 555-7890, info@greenleaflandscaping.com")),
                customerRepository.save(new Customer("TechGuru IT Solutions", "Comprehensive IT support and consulting services, offering network setup, cybersecurity, and software development for businesses of all sizes.", "IT Support", "(512) 555-1234, support@techguru.com")),
                customerRepository.save(new Customer("Pure Health Wellness Center", "Holistic health and wellness services, including chiropractic care, massage therapy, and nutritional counseling.", "Wellness", "(415) 555-6789, contact@purehealth.com")),
                customerRepository.save(new Customer("Gourmet Bites Catering", "Full-service catering for events of all sizes, offering customized menus with gourmet cuisine for weddings, corporate events, and private parties.", "Event Services", "(305) 555-7891, catering@gourmetbites.com")),
                customerRepository.save(new Customer("Elite Fitness Gym", "State-of-the-art fitness center with personal training, group classes, and wellness programs to help members achieve their health and fitness goals.", "Fitness", "(650) 555-2345, fit@elitefitness.com"))
            );

            customerRepository.saveAll(customers);
        };
    }
}
