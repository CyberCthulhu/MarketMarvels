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
                customerRepository.save(new Customer("Savings Accounts", "Our savings accounts offer a secure and convenient way to save money. With competitive interest rates and no monthly fees, you can watch your savings grow while having easy access to your funds when you need them.", "Savings Accounts", "(217) 555-7890, saving@gciti.com")),
                customerRepository.save(new Customer("Personal Loans", "Need extra cash for a major purchase or unexpected expenses? Our personal loans provide flexible borrowing options with competitive rates and terms. Whether you're looking to consolidate debt or fund a home improvement project, we're here to help.", "Personal Loans", "(512) 555-1234, personal@citi.com")),
                customerRepository.save(new Customer("Online Banking", "Manage your finances conveniently from anywhere with our online banking services. Access your accounts, transfer funds, pay bills, and more—all from the comfort of your home or on the go with our mobile banking app.", "Online Banking", "(415) 555-6789, banking@citi.com")),
                customerRepository.save(new Customer("Investment Advisory Services", "Our investment advisory services provide personalized investment strategies tailored to your financial goals and risk tolerance. Our team of experienced advisors will help you navigate the complexities of the financial markets.", "Investment Advisory Services", "(305) 555-7891, invest@citi.com")),
                customerRepository.save(new Customer("Mortgage Loans", "Whether you're buying your first home or refinancing an existing mortgage, our mortgage loans offer competitive rates and flexible terms. Our mortgage specialists will guide you through the entire process.", "Mortgage Loans", "(650) 555-2345, loan@citi.com"))
            );

            customerRepository.saveAll(customers);
        };
    }
}
