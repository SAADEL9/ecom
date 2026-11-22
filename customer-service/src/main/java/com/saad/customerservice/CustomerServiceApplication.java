package com.saad.customerservice;

import com.saad.customerservice.config.CustomerConfigParams;
import com.saad.customerservice.entities.Customer;
import com.saad.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties(CustomerConfigParams.class)
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner start(CustomerRepository customerRepository){
    return args -> {
        customerRepository.save(Customer.builder().name("saad").email("saad@gmail.com").build());
        customerRepository.save(Customer.builder().name("anas").email("anas@gmail.com").build());
        customerRepository.save(Customer.builder().name("mohamed").email("mohamed@gmail.com").build());
        customerRepository.save(Customer.builder().name("achraf").email("achraf@gmail.com").build());
    };
    }
}
